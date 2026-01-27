package org.example.threads_coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() {
    // programm01_flow_hot()
    // programm02_flow_hot()
    // programm03_flow_hot()
    // programm04_flow_hot()

    // programm06_flow_hot()
    // programm07_flow_hot()

    programm08_flow_hot()

}


fun programm01_flow_hot() {

    val originalFlow = flowOf(1, 2, 3, 4, 5)
        .onEach {
            println("Sending $it from ${Thread.currentThread().name}")
        }

    runBlocking {
        originalFlow.collect()
    }
}

fun programm02_flow_hot() {
    val originalFlow = flowOf(1, 2, 3, 4, 5)
        .onEach {
            println("Sending $it from ${Thread.currentThread().name}")
        }
    val sharedFlow = originalFlow
        .shareIn(scope = CoroutineScope(newFixedThreadPoolContext(4, "dispatcher")),
            started = SharingStarted.Lazily,
            replay = 2
        )
    // Запустим 5 корутин
    runBlocking {
        repeat(5) { id ->
            launch(Dispatchers.Default) {
                sharedFlow.map { value ->
                    println("Coroutine $id got $value on ${Thread.currentThread().name}")
                }.collect()
            }
        }
        delay(100)
    }
}

fun programm03_flow_hot() {
    val originalFlow = flowOf(1, 2, 3, 4, 5)
        .onEach {
            println("Sending $it from ${Thread.currentThread().name}")
        }
    val sharedFlow = originalFlow
        .stateIn(
            scope = CoroutineScope(Dispatchers.Default),
            started = SharingStarted.WhileSubscribed(),
            initialValue = 0,
        )
    // Запустим 5 корутин
    runBlocking {
        repeat(5) { id ->
            launch(Dispatchers.Default) {
                sharedFlow.map { value ->
                    println("Coroutine $id got $value on ${Thread.currentThread().name}")
                }.collect()
            }
        }
        delay(100)
    }
}

fun programm04_flow_hot() {
    val scope = CoroutineScope(Dispatchers.Default)
    val flowTread = flow {
        for (i in 1..10) {
            println("Send - $i")
            emit(i)
            delay(100)
        }
    }

    scope.launch {
        flowTread.collect { value ->
            println(value)
        }
    }

    //scope.cancel()
}

fun programm05_flow_hot() {
    val simpleFlow: Flow<Int> = flowOf(1, 2, 3)

    val list01 = arrayOf(3, 4, 5, 6)
    val flowFromLost01 = list01.asFlow()

    val channelBasedFlow = channelFlow {
        send(1)
        send(2)
        send(3)
    }

    val empty = emptyFlow<Int>()

    runBlocking {

    }
}

fun programm06_flow_hot() {
    val stock: Flow<Int> = flow {
        var i = 0
        while(true) {
            emit(++i)
            delay(100)
        }
    }

    runBlocking {
        var seconds = 0
        stock.collect { number ->
            delay(1000)
            seconds++
            println("$seconds seconds -> received $number")
        }
    }
}

fun programm07_flow_hot() {
    val stock: Flow<Int> = flow {
        var i = 0
        while(true) {
            emit(++i)
            delay(100)
        }
    }

    //conflate - только пооследние
    runBlocking {
        var seconds = 0
        stock.conflate().collect { number ->
            delay(1000)
            seconds++
            println("$seconds seconds -> received $number")
        }
    }
}

fun programm08_flow_hot() {
    val stock: Flow<Int> = flow {
        var i = 0
        while(true) {
            emit(++i)
            delay(100)
        }
    }

    val debounceFlow = stock.debounce(300L)

    val sampleFlow = stock.sample(1000L)

    runBlocking {
        flowOf(1, 2, 3, 3 , 1 ,2 ,4 ,5 ,5, 5, 6)
            .distinctUntilChanged()
            .onEach { println(it) }
            .collect()
    }

}
