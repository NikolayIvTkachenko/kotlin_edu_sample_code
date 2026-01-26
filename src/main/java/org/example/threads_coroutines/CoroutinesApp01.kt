package org.example.threads_coroutines

import kotlinx.coroutines.*
import java.util.UUID
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

fun main() {

    // programm01_hello_coroutines()
    // programm02()
    runBlocking {
        programm03_type_blocking_async_suspend()
    }

}

fun programm01_hello_coroutines() {

    val latch = CountDownLatch(10_000)
    val c = AtomicInteger()
    val start = System.currentTimeMillis()

    for (i in 1..10_000) {
        with(GlobalScope) {
            launch {
                c.incrementAndGet()
                delay(100)
                c.incrementAndGet()
                latch.countDown()
            }
        }
    }
    latch.await(10, TimeUnit.SECONDS)

    println("Executed ${c.get() / 2} coroutines in ${System.currentTimeMillis() - start} ms")
}

fun fastUuidAsync() = GlobalScope.async {
    UUID.randomUUID()
}

fun programm02() {
    runBlocking {
        val job: Deferred<UUID> = fastUuidAsync()
        println(job.await())
    }
}

suspend fun programm03_type_blocking_async_suspend() {
    val t1 = measureTimeMillis {
        Blocking.profile("123")
    }

    val t2 = measureTimeMillis {
        Async().profile("123")
    }

    println("t1 = $t1")
    println("t2 = $t2")
}