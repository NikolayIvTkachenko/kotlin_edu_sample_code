package org.example.coroutines_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.io.IOException
import java.lang.NumberFormatException
import java.util.function.BiPredicate

val upstream: Flow<Int> = flowOf(1, 2, 3, 4)

val upstreamV2: Flow<Int> = flowOf(1, 2, 3, 4)
    .onEach { value ->
        if (value > 2) throw java.lang.RuntimeException()
    }

val upstreamV3: Flow<Int> = flow {
    for (i in 1..3) {
        try {
            emit(i)
        } catch (e: Throwable) {
            println("Interception downstream exception $e")
        }
    }
}

val upstreamV4: Flow<Int> = flowOf(1, 3, -1)

val violatesExceptionTransparency: Flow<Int> = flow {
    for (i in 1..3) {
        try {
            emit(i)
        } catch (e: Throwable) {
            emit(-1)
        }
    }
}

val encapsulateError: Flow<Int> = upstream
    .onEach {
        if (it > 2) throw RuntimeException()
    }
    .catch {e ->
        println("Caught $e")
    }

val encapsulateErrorV2: Flow<Int> = upstreamV4
    .onEach {
        if (it < 0) throw NumberFormatException("Values should be greater than 0")
    }
    .catch {e ->
        println("Caught $e")
    }



val urlFlow = flowOf("url-1", "url-2", "url-retry")

data class Image(val url: String)

suspend fun fetchImage(url: String): Image {
    delay(10)
    if(url.contains("retry")) {
        throw IOException("Server returned HTTP response code 503")
    }
    return Image(url)
}

sealed class Result {
    data class Success(val image: Image): Result()
    data class Error(val url: String): Result()
}

suspend fun fetchResult(url: String): Result {
    println("Fetching $url...")
    return try {
        val image = fetchImage(url)
        Result.Success(image)
    } catch (e: IOException) {
        Result.Error(url)
    }
}




fun main(): Unit = runBlocking {
    //tryCatchTest001()
    //tryCatchTest002()
    //tryCatchTest003()
    //tryCatchTest004()
    //tryCatchTest005()
    //tryCatchTest006()
    //tryCatchTest007()
    tryCatchTest008()

    //Thread.sleep(1000)
}

private suspend fun tryCatchTest001() {
    try {
        upstream.collect {value ->
            if (value > 2) {
                throw RuntimeException()
            }
            println("Received $value")
        }
    } catch (e: Throwable) {
        println("Caught $e")
    }
}

private suspend fun tryCatchTest002() {
    try {
        upstreamV2.collect { value ->
            println("Received $value")
        }
    } catch (e: Throwable) {
        println("Caught $e")
    }
}

private suspend fun tryCatchTest003() {
    try {
        upstreamV3.collect { value ->
            println("Recieved $value")
            check(value <= 2) {
                "Collected $value while we expect values below 2"
            }
        }
    } catch (e: Throwable) {
        println("Caught $e")
    }
}

private suspend fun tryCatchTest004() {
    try {
        violatesExceptionTransparency.collect { value ->
            check(value <= 2) {
                "Collected $value"
            }
        }
    } catch (e: Throwable) {
        println("Caught $e")
    }
}

private suspend fun tryCatchTest005() {
    encapsulateError.collect {
        println("Received $it")
    }
}

private suspend fun tryCatchTest006() {
    try {
        encapsulateErrorV2.collect {
            if (it > 2) throw java.lang.RuntimeException()
            println("Received $it")
        }
    } catch (e: Throwable) {
        println("Caught $e")
    }
}

private suspend fun tryCatchTest007() {
    val resultFlow = urlFlow.map { url ->
        fetchResult(url)
    }
    val results = resultFlow.toList()
    println("Results: $results")
}

fun <T, R : Any> Flow<T>.mapWithRetry(
    action: suspend(T) -> R,
    predicate: suspend(R, attempt: Int) -> Boolean,
) = map { data ->
    var attempt: Int = 0
    var shallRetry: Boolean
    var lastValue: R? = null

    do {
        val tr = action(data)
        shallRetry = predicate(tr, ++attempt)
        if (!shallRetry) lastValue = tr
    } while (shallRetry)
    return@map lastValue
}

private suspend fun tryCatchTest008() {
    val resultFlow = urlFlow.mapWithRetry(
        {url -> fetchResult(url) },
        {value, attempt -> value is Error && attempt < 3L}
    )
    val results = resultFlow.toList()
    println("Results: $results")
}