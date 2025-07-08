package org.example.coroutines_flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() = runBlocking<Unit> {
    //test001()
    test002()
}

suspend fun transform(i: Int): String = withContext(Dispatchers.Default) {
    delay(10)
    println(Thread.currentThread().name)
    "${i+1}"
}

suspend fun test001() {
    val flowNumbers = numbers()
    flowNumbers.collect {
        println(it)
    }
}

suspend fun test002() {
    val flowNumbers = numbers()
    val flowNumbersNew: Flow<String> = numbers().map {
        transform(it)
    }
    flowNumbersNew.collect {
        println(it)
        println(Thread.currentThread().name)
    }
}

fun numbers(): Flow<Int> = flow {
    emit(1)
    emit(2)
    emit(3)
    emit(4)
}