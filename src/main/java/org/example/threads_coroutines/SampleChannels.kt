package org.example.threads_coroutines

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    // program01_channels()
    // program02_channels()
    // program03_channels()
    // program04_channels()
    // program05_channels()
    program06_channels()
}


fun program01_channels() {

    runBlocking {
        val chan = Channel<Int>()
        launch {
            for (c in chan) {
                println(c)
            }
        }

        (1..10).forEach {
            chan.send(it)
        }

        chan.close()
    }
}

fun program02_channels() {
    runBlocking {
        val chan = produce {
            (1..10).forEach {
                send(it)
            }
        }

        launch {
            chan.consumeEach {
                println(it)
            }
        }
    }
}

fun program03_channels() {
    runBlocking {
        val actor = actor<Int> {
            channel.consumeEach {
                println(it)
            }
        }

        (1..11).forEach {
            actor.send(it)
        }
    }
}

fun program04_channels() {
    runBlocking {
        val actor = actor<Long> {
            var prev = 0L
            channel.consumeEach {
                println(it - prev)
                prev = it
                delay(100)
            }
        }

        repeat(10) {
            actor.send(System.currentTimeMillis())
        }
        actor.close().also { println("Done sending") }
    }
}

fun program05_channels() {
    runBlocking {
        val actor = actor<Long>(capacity = 10) {
            var prev = 0L
            channel.consumeEach {
                println(it - prev)
                prev = it
                delay(100)
            }
        }

        repeat(10) {
            actor.send(System.currentTimeMillis())
        }
        actor.close().also { println("Done sending") }
    }
}

fun program06_channels() {
    runBlocking {
        val chan = produce(capacity = 10) {
            (1..10).forEach {
                send(it)
            }
        }
        launch {
            chan.consumeEach {
                println(it)
            }
        }
        //val chan = Channel<Int>(10)
    }
}