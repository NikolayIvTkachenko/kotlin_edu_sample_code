package org.example.patterns.builder

import java.io.File


fun main() {

}

fun program001() {
    val mail = Mail("manager@company.com", listOf(), listOf(), "Ping", null, null)
    val mailV2 = MailV2("manager@company.com").apply {
        title = "Main Version V2"
        message = "Something"
    }
}

//---Builder by Kotlin way----
data class MailV2(
    val to: String,
    var title: String = "",
    var message: String = "",
    val cc: List<String> = listOf(),
    val bcc: List<String> = listOf(),
    val attachments: List<java.io.File> = listOf(),
)

//---Standard class---
data class Mail(
    val to: String,
    val cc: List<String>,
    val bcc: List<String>,
    val title: String?,
    val message: String?,
    val attachments: List<File>?
)