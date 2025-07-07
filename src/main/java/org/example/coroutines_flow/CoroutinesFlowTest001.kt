package org.example.coroutines_flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    test001()
}

suspend fun test001() {
    val flowNumbers = numbers()
    flowNumbers.collect {
        println(it)
    }
}

fun numbers(): Flow<Int> = flow {
    emit(1)
    emit(2)
    emit(3)
    emit(4)
}