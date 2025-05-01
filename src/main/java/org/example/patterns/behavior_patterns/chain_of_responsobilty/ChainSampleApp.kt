package org.example.patterns.behavior_patterns.chain_of_responsobilty

import java.lang.IllegalArgumentException


interface Handler {
    fun handle(request: Request): Response
}



data class Request(val email: String, val question: String)
data class Response(val answer: String)

fun String.isKnowEmail() = false //true //false
fun String.isJuniourDeveloper() = false

//OLD VARIANT
fun handleRequest(r: Request) {

    //Validate
    if(r.email.isEmpty() || r.question.isEmpty()) {
        return
    }
    //Authenticate
    //Make sure that you know whos is this user
    if(r.email.isKnowEmail()) {
        return
    }

    //Authorize
    //Request from juniors are automatically ignored by architects
    if(r.email.isJuniourDeveloper()) {
        return
    }

    println("Get Answer")
}

//NEW VARIANT
class BasicValidationHandler(private val next: Handler): Handler {
    override fun handle(request: Request): Response {
        if(request.email.isEmpty() || request.question.isEmpty()) {
            throw IllegalArgumentException()
        }
        return next.handle(request)
    }
}

class AuthenticationHandler(private val next: Handler): Handler {
    override fun handle(request: Request): Response {
        if(request.email.isKnowEmail()) {
            throw IllegalArgumentException()
        }
        return next.handle(request)
    }
}

class FileResponseHandler(): Handler {
    override fun handle(request: Request): Response {
        return Response("Email: ${request.email}  ==>  Request ${request.question}")
    }

}



fun main() {
    val req = Request("developer@company.com", "Test build request")

    val chain = AuthenticationHandler(BasicValidationHandler(FileResponseHandler()))

    val result = chain.handle(req)

    println(result)
}
