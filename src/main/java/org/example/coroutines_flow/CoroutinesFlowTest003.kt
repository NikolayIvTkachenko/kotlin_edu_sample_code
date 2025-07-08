package org.example.coroutines_flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.LocalDateTime

fun main() = runBlocking<Unit> {
    testSimple001()
}

private data class Message(val user: String, val date: LocalDateTime, var content: String) {
    fun translate(language: String) {
        content = "$language -> $content"
    }
}

private suspend fun getMessageFlow(): Flow<Message> {
    return flow {
        emit(Message("User_001", LocalDateTime.now(), "Content_001"))
        emit(Message("User_002", LocalDateTime.now(), "Content_002"))
        emit(Message("User_003", LocalDateTime.now(), "Content_003"))
        emit(Message("User_004", LocalDateTime.now(), "Content_004"))
        emit(Message("User_005", LocalDateTime.now(), "Content_005"))
        emit(Message("User_006", LocalDateTime.now(), "Content_006"))
        emit(Message("User_007", LocalDateTime.now(), "Content_007"))
        emit(Message("User_008", LocalDateTime.now(), "Content_008"))
        emit(Message("User_009", LocalDateTime.now(), "Content_009"))
        emit(Message("User_0010", LocalDateTime.now(), "Content_0010"))
    }
}

private suspend fun getMessagesFromUser(user: String, language: String): Flow<Message> {
    return getMessageFlow()
        .filter { it.user == user }
        .map {
            it.translate(language)
            it
        }
        .flowOn(Dispatchers.Default)
}

private suspend fun testSimple001() {

    val jobTest0001 = GlobalScope.launch {
        getMessagesFromUser("User_002", "RU")
            .collect {
                println(it)
                println(Thread.currentThread().name)
            }
    }
    jobTest0001.join()
}