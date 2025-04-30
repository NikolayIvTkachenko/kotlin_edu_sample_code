package org.example.patterns.creation_patterns.builder

import java.io.File


fun main() {
    program001()
}

fun program001() {
    val mail = Mail("manager@company.com", listOf(), listOf(), "Ping", null, null)
    println(mail)
    println()
    println("----------------------")

    val mailV2 = MailV2("manager@company.com").apply {
        title = "Main Version V2"
        message = "Something"
    }
    println(mailV2)
    println()
    println("----------------------")
    //Use Builder
    val mailV2_2 = MailV2Builder("manager@company.com").title("Main").message("Something").build()
    println(mailV2_2)
}



//---Builder by Kotlin way----
class MailV2Builder(val to: String) {
    private var mail: MailV2 = MailV2(to)

    fun title(title: String): MailV2Builder {
        mail.title = title
        return this
    }

    fun message(message: String): MailV2Builder {
        mail.message = message
        return this
    }

    fun build(): MailV2 {
        return mail
    }
}


//Kotlin Version
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