package org.example.coroutines_flow

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.lang.NumberFormatException

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

fun main(): Unit = runBlocking {
    //tryCatchTest001()
    //tryCatchTest002()
    //tryCatchTest003()
    //tryCatchTest004()
    //tryCatchTest005()
    tryCatchTest006()

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