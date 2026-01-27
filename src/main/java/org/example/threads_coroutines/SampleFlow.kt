package org.example.threads_coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Exception
import java.lang.RuntimeException

fun main() {
    // programm01_flow()
    // programm02_flow()
    // programm03_flow()
    // programm04_flow()
    // programm05_flow()

    programm06_flow()

}

fun programm01_flow() {
    val numbersFlow = flow {
        (0..10).forEach {
            println("Sending $it")
            emit(it)
        }
    }

    runBlocking {
        numbersFlow.collect { n ->
            println("Listener received $n")
        }
    }
}

fun programm02_flow() {
    val numbersFlow: Flow<Int> = flow {
        println("New subscriber!")
        (1..10).forEach {
            println("Sending $it")
            emit(it)
            if (it == 9) {
                throw RuntimeException()
            }
        }
    }
    runBlocking {
        try {
            numbersFlow.collect { n ->
                println("Listener received $n")
            }
        } catch (e: Exception) {
            println("Got an error")
        }
    }
}

fun programm03_flow() {
    runBlocking {
        val moreNumbersFlow = (1..10).asFlow()

        moreNumbersFlow.map {
            println("Mapping on ${Thread.currentThread().name}")
            it * it
        }.flowOn(Dispatchers.Default).collect {
            println("Got $it on ${Thread.currentThread().name}")
        }
    }
}

fun programm04_flow() {

    val numbersFlow = flow {
        (0..10).forEach {
            println("Sending $it")
            emit(it)
        }
    }

    runBlocking {
        (1..4).forEach {  coroutineId ->
            delay(5000)
            launch(Dispatchers.Default) {
                numbersFlow.collect { n ->
                    delay(1000)
                    println("Coroutine $coroutineId recevied $n")
                }
            }
        }
    }
}

fun programm05_flow() {

    val numbersFlow = flow {
        (0..10).forEach {
            println("Sending $it")
            emit(it)
        }
    }

    runBlocking {
        (1..4).forEach {  coroutineId ->
            delay(5000)
            launch(Dispatchers.Default) {
                numbersFlow.buffer().collect { n ->
                    delay(1000)
                    println("Coroutine $coroutineId recevied $n")
                }
            }
        }
    }
}

fun programm06_flow() {
    // val numFlows =
    runBlocking {
        flow {
            var i = 3
            repeat(5) {
                emit(10 / i--)
            }
        }
            .catch { e -> println("Caught exception: $e") }
            .collect { value -> println(value) }
    }

}