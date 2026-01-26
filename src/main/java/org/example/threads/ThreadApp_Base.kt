package org.example.threads

import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread
import kotlin.system.exitProcess

fun main() {
    // programThread01()
    // programThread02()
    // programThread03()
    // programThread04()
    // programThread05()


    // programThread06()

    programThread07()



}


fun programThread01() {
    repeat(2) { t ->
        thread {
            for (i in 1..100) {
                println("T$t: $i")
            }
        }
    }
}

fun programThread02() {
    val t = thread(start = false) {
        // BODY OF THREAD
    }
    t.start()
}

fun programThread03() {
    val t = thread(isDaemon = true, start = false) {
        for (i in 1..1_000_000) {
            println("deamon thread = $i")
        }
    }
    t.start()
    Thread.sleep(10)
}


// Not synchronized, incorrect working
fun programThread04() {
    var counter = 0
    val latch = CountDownLatch(100_000)
    repeat(100) {
        thread {
            repeat(1000) {
                counter++
                latch.countDown()
            }
        }
    }
    latch.await()
    println("Counter $counter")
}

// Synchronized, Correct working
fun programThread05() {
    var counter = 0
    val latch = CountDownLatch(100_000)
    repeat(100) {
        thread {
            repeat(1000) {
                synchronized(latch) {
                    counter++
                    latch.countDown()
                }
            }
        }
    }
    latch.await()
    println("Counter $counter")
}

@Volatile
var shareByMultipleThreads: Int = 0


// Не падает с ошибкой, так как высоукопроизводительный ПК
fun programThread06() {
    val counter = AtomicInteger()

    val threads: List<Thread> = try {
        List(100_000) {// 1_000_000
            thread {
                Thread.sleep(1000)
                counter.incrementAndGet()
            }
        }
    } catch (e: Exception) {
        println("Spawned ${counter.get()} threads before crashing ")
        exitProcess(-42)
    }

    threads.forEach {
        it.join()
    }

    println("Finished without running Out of Memory consuming ${
        (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 /1024
    } Mb")
}

fun programThread07() {
    val pool = Executors.newFixedThreadPool(100)
    val counter = AtomicInteger(0)
    val start = System.currentTimeMillis()
    for (i in 1..10_000) {
        pool.submit{
            counter.incrementAndGet()
            Thread.sleep(100)
            counter.incrementAndGet()
        }
    }

    pool.awaitTermination(20, TimeUnit.SECONDS)
    pool.shutdown()
    println("Took me ${System.currentTimeMillis() - start} millis to complete ${counter.get() / 2} tasks")
}
