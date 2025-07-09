package org.example.coroutines_flow

import kotlinx.coroutines.*
import java.io.IOException
import java.lang.AssertionError
import java.lang.Exception

fun main() = runBlocking<Unit> {
    //testCoroutines1001()
    //testCoroutines1002()
    //testCoroutines1003()
    //testCoroutines1004()
    //testCoroutines1005()
    //testCoroutines1006()
    // testCoroutines1007() //==> Exception
    //testCoroutines1008() //==> Exception
    //testCoroutines1009()
    testCoroutines1010()
    //testCoroutines1011()  //==> Exception
}

suspend fun testCoroutines1001() {
    val scope = CoroutineScope(Dispatchers.Default)
    val job = scope.launch {
        val child1 = launch {
            delay(Long.MAX_VALUE)
        }
        val child2 = launch {
            child1.join()
            println("Child 1 is canceled")

            delay(100)
            println("Child 2 is still alive!")
        }

        println("Cancelling child 1..")
        child1.cancel()
        child2.join()
        println("Parent is not cancelled")
    }
    job.join()
}

suspend fun testCoroutines1002() { //-->Crash
    val scope = CoroutineScope(Dispatchers.Default + Job())
    val job = scope.launch {
        launch {
            try {
                delay(Long.MAX_VALUE)
            } finally {
                println("Child 1 was cancelled")
            }
        }
        launch {
            delay(100)
            throw IOException()
        }
    }
    job.join()
}

suspend fun testCoroutines1003() {
    val ceh = CoroutineExceptionHandler { _, exception ->
        println("Caught original $exception")
    }
    val scope = CoroutineScope(Dispatchers.Default + Job() + ceh)
    val job = scope.launch {
        launch {
            try {
                delay(Long.MAX_VALUE)
            } finally {
                println("Child 1 was cancelled")
            }
        }
        launch {
            delay(100)
            throw IOException()
        }
    }
    job.join()
}

suspend fun testCoroutines1004() {
    val ceh = CoroutineExceptionHandler { _, exception ->
        println("Handled => $exception")
    }
    val supervisor = SupervisorJob()
    val scope = CoroutineScope(Dispatchers.Default + supervisor + ceh)

    with(scope) {
        val firstChild = launch {
            println("First child is failing")
            throw AssertionError("First child is cancelling")
        }

        val secondChild = launch {
            firstChild.join()
            delay(10)
            println("First child is cancelled: ${firstChild.isCancelled}, but second ome is still active")
        }
        secondChild.join()
    }
}

suspend fun testCoroutines1005() {
    val ceh = CoroutineExceptionHandler { _, exception ->
        println("Handled => $exception")
    }
    val supervisor = SupervisorJob()
    val scope = CoroutineScope(Dispatchers.Default + supervisor)

    with(scope) {
        val firstChild = launch(ceh) {
            println("First child is failing")
            throw AssertionError("First child is cancelling")
        }

        val secondChild = launch {
            firstChild.join()
            delay(10)
            println("First child is cancelled: ${firstChild.isCancelled}, but second ome is still active")
        }
        secondChild.join()
    }
}


suspend fun testCoroutines1006() {
    val scope = CoroutineScope(Job())

    val job = scope.launch {
        supervisorScope {
            val task1 = launch {
                delay(1000)
                println("Done background task")
            }

            val task2 = async {
                throw Exception()
                1
            }

            try {
                task2.await()
            } catch (e: Exception) {
                println("Caught exception $e")
            }
            task1.join()
        }
    }
    job.join()
    println("Program ends")
}

suspend fun testCoroutines1007() {
    val scope = CoroutineScope(Job())

    val job = scope.launch {
        supervisorScope {
            val task1 = launch {
                delay(1000)
                println("Done background task")
            }

            val task2 = async {
                throw Exception()
                1
            }

            task2.await()
            task1.join()
        }
    }
    job.join()
    println("Program ends")
}

suspend fun testCoroutines1008() {
    val scope = CoroutineScope(Job())

    val job = scope.launch {
        coroutineScope {
            val task1 = launch {
                delay(1000)
                println("Done background task")
            }

            val task2 = async {
                throw Exception()
                1
            }

            try {
                task2.await()
            } catch (e: Exception) {
                println("Caught exception $e")
            }
            task1.join()
        }
    }
    job.join()
    println("Program ends")
}

suspend fun testCoroutines1009() {
    val ceh = CoroutineExceptionHandler{ _, t ->
        println("CEH handle $t")
    }
    val scope = CoroutineScope(Job())

    val job = scope.launch(ceh) {
        coroutineScope {
            val task1 = launch {
                delay(1000)
                println("Done background task")
            }

            val task2 = async {
                throw Exception()
                1
            }

            try {
                task2.await()
            } catch (e: Exception) {
                println("Caught exception $e")
            }
            task1.join()
        }
    }
    job.join()
    println("Program ends")
}

suspend fun testCoroutines1010() {
    val ceh = CoroutineExceptionHandler{ _, t ->
        println("CEH handle $t")
    }
    val scope = CoroutineScope(Job() + ceh)

    val job = scope.launch() {
        coroutineScope {
            val task1 = launch {
                delay(1000)
                println("Done background task")
            }

            val task2 = async {
                throw Exception()
                1
            }

            try {
                task2.await()
            } catch (e: Exception) {
                println("Caught exception $e")
            }
            task1.join()
        }
    }
    job.join()
    println("Program ends")
}

suspend fun testCoroutines1011() {
    val ceh = CoroutineExceptionHandler{ _, t ->
        println("CEH handle $t")
    }
    val scope = CoroutineScope(Job())

    val job = scope.launch() {
        coroutineScope {
            val task1 = launch {
                delay(1000)
                println("Done background task")
            }

            val task2 = launch(ceh) {
                throw Exception()
                1
            }

            task1.join()
            task2.join()
        }
    }
    job.join()
    println("Program ends")
}