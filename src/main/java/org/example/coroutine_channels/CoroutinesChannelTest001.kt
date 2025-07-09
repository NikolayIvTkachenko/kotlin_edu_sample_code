package org.example.coroutine_channels

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlin.random.Random

data class Item(val number: Int)

suspend fun makeItem(): Item {
    delay(10)
    return Item(Random.nextInt())
}

suspend fun getItems(): List<Item> {
    val items = mutableListOf<Item>()

    items.add(makeItem())
    items.add(makeItem())
    items.add(makeItem())

    return items
}

fun consumeItems(items: List<Item>) {
    for(item in items) println("Do something with $item")
}

fun main() = runBlocking {
    //testChannelCoroutine001()
    //testChannelCoroutine002()
    //testChannelCoroutine003()
    //testChannelCoroutine004()
    testChannelCoroutine005()
    //testChannelCoroutine006()
    //testChannelCoroutine007()

}

suspend fun testChannelCoroutine001() {
    val items = getItems()
    consumeItems(items)
}

suspend fun testChannelCoroutine002() {
    val scope = CoroutineScope(Dispatchers.Default)
    val channel = Channel<Item>()

    scope.launch {
        channel.send(Item(1))
        channel.send(Item(2))
        channel.send(Item(3))
        println("Done sending")
    }

    println(channel.receive())
    println(channel.receive())
    println(channel.receive())
    println("Dome program")
}

suspend fun testChannelCoroutine003() {
    //Перебор канала
    val scope = CoroutineScope(Dispatchers.Default)
    val channel = Channel<Item>()

    scope.launch {
        channel.send(Item(1))
        channel.send(Item(2))
        channel.send(Item(3))
        println("Done sending")
        channel.close() //Закрытие канала, разрав цикла, чтобы не выполнялся бесконечно перебор канала
    }

    for(x in channel) {
        println(x)
    }
    println("Dome program")
}

suspend fun testChannelCoroutine004() {
    //Перебор канала
    val scope = CoroutineScope(Dispatchers.Default)
    val channel = Channel<Item>()
    channel.close()

    for(x in channel) {
        println(x)
    }
    println("Dome program")
}

suspend fun testChannelCoroutine005() {
    val scope = CoroutineScope(Dispatchers.Default)
    val channel = Channel<Int>(Channel.UNLIMITED)

    val childJob = scope.launch {
        println("Child executing from ${Thread.currentThread().name}")
        var i = 0
        while(isActive) {
            channel.send(i++)
        }
        println("Child is done sending")
    }

    println("Parent executing from ${Thread.currentThread().name}")

    println("Done ==> ")
}

suspend fun testChannelCoroutine006() {
    val scope = CoroutineScope(Dispatchers.Default)
    val channel = Channel<Int>(Channel.CONFLATED)

}

suspend fun testChannelCoroutine007() {
    val scope = CoroutineScope(Dispatchers.Default)
    val channel = Channel<Int>(Channel.BUFFERED)

}