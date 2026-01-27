package org.example.threads_coroutines

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.lang.RuntimeException
import kotlin.random.Random

fun main() {
    // programm001()
    // programm002()
    programm003()


}


fun programm001() {
    runBlocking {
        flow {
            emit(1)
            emit(2)
        }
            .onCompletion { cause ->
                if (cause != null) {
                    println("Flow completed with exception: $cause")
                } else {
                    println("Flow completed successfully")
                }
            }
            .collect { println(it) }
    }
}

fun doSomethingRisky(): Int {
    val randomNumber = Random.nextInt(10)
    if (randomNumber > 4) {
        throw RuntimeException(randomNumber.toString())
    }
    return randomNumber
}

fun programm002() {
    runBlocking {
        flow {
            repeat(3) {
                emit(doSomethingRisky())
            }
        }
            .retry(10) { e: Throwable ->
                println("Got $e, retrying")
                true
            }
            .collect { println(it) }
    }
}

class Http5XX(message: String): Throwable(message)
class Http4XX(message: String): Throwable(message)

fun doSomethingHttpRisky(): Int {
    val randomNumber = Random.nextInt(10)
    if (randomNumber < 2) {
        throw Http5XX(randomNumber.toString())
    } else if (randomNumber < 5) {
        throw Http4XX(randomNumber.toString())
    }
    return randomNumber
}

fun programm003() {
    runBlocking {
        flow {
            repeat(3) {
                emit(doSomethingHttpRisky())
            }
        }.retryWhen { e: Throwable, attempt: Long ->
            println("Got $e, retrying")
            println("attempt $attempt, retrying")
            when {
                (e is Http5XX) && attempt > 10 -> false
                (e is Http4XX) && attempt > 3 -> false
                else -> true
            }
        }.collect { println(it) }

    }
}

fun programm004() {
    runBlocking {

    }
}
