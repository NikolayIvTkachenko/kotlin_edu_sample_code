package org.example.coroutines_flow

import kotlinx.coroutines.*

data class Hike(
    val name: String,
    val miles: Float,
    val ascentInFeet: Int,
)

class Weather

data class HikeData(val hike: Hike, val weather: Weather?)

fun main() = runBlocking<Unit> {
    //testCoroutines001()
    testCoroutines002()
}

suspend fun fetchData() {
    println("Working fetchData()")
}

suspend fun fetchOtherData() {
    println("Working fetchOtherData()")
}

suspend fun testCoroutines001() {
    val scope = CoroutineScope(Job())
    val job = scope.launch(start = CoroutineStart.LAZY) {
        launch {
            fetchData()
        }
        launch {
            fetchOtherData()
        }
    }

    job.start()
    job.join()
}

suspend fun testCoroutines002() {
    val scope = CoroutineScope(Job())
    val startTime = System.currentTimeMillis()
    val job = scope.launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        while (true) {
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("Job: I'm working...")
                nextPrintTime += 500
            }
        }
    }
    //job.join()
    job.cancelAndJoin()
    println("Done")
}

suspend fun testCoroutines003() {

}