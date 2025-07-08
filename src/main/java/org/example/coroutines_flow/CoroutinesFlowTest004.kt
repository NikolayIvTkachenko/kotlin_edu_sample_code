package org.example.coroutines_flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.time.LocalDateTime

fun main() = runBlocking<Unit> {
    testSimple001()
}

private data class MessageV2(val user: String, val date: LocalDateTime, var content: String)

private suspend fun MessageV2.translate(
    language: String
): MessageV2 = withContext(Dispatchers.IO) {
    copy(content = "$language -> $content")
}

private suspend fun getMessageFlow(): Flow<MessageV2> {
    return flow {
        emit(MessageV2("User_001", LocalDateTime.now(), "Content_001"))
        emit(MessageV2("User_002", LocalDateTime.now(), "Content_002"))
        emit(MessageV2("User_003", LocalDateTime.now(), "Content_003"))
        emit(MessageV2("User_004", LocalDateTime.now(), "Content_004"))
        emit(MessageV2("User_005", LocalDateTime.now(), "Content_005"))
        emit(MessageV2("User_006", LocalDateTime.now(), "Content_006"))
        emit(MessageV2("User_007", LocalDateTime.now(), "Content_007"))
        emit(MessageV2("User_008", LocalDateTime.now(), "Content_008"))
        emit(MessageV2("User_009", LocalDateTime.now(), "Content_009"))
        emit(MessageV2("User_0010", LocalDateTime.now(), "Content_0010"))
    }
}

private suspend fun getMessagesFromUser(user: String, language: String): Flow<MessageV2> {
    return getMessageFlow()
        .filter { it.user == user }
        .map {
            it.translate(language)
        }
        .flowOn(Dispatchers.Default)
}

private suspend fun testSimple001() {

    val jobTest0001 = GlobalScope.launch {
        getMessagesFromUser("User_004", "EN")
            .collect {
                println(it)
                println(Thread.currentThread().name)
            }
    }
    jobTest0001.join()
}