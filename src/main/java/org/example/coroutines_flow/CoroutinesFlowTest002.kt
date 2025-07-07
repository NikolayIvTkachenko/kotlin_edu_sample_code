package org.example.coroutines_flow

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

data class TokenData(val token: String, val opt: String? = null)

fun main() = runBlocking<Unit> {
    testReal001()
}

private fun getToken(): String {
    return "TOKEN0001"
}

private fun getData(): String {
    return "DATA_0001"
}

private fun connect() {
    println("Connect to DataBase")
}

private fun disconnect() {
    println("Disconnect from DataBase")
}
private fun getDataFlow(n: Int): Flow<TokenData> {
    return flow {
        connect()
        repeat(n) {
            val token = getToken()
            val data = getData()
            emit(TokenData(token, data))
        }
    }.onCompletion {
        disconnect()
    }
}
suspend fun testReal001() {
    val flowData = getDataFlow(3)
    val job = GlobalScope.launch {
        flowData.collect{ data ->
            println(data)
        }
    }
    job.join()
}

