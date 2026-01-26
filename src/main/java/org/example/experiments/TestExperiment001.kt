package org.example.experiments

import java.lang.Exception

fun main() {

    var test00 = 5

    val volume = try {
        test00 / 0
    } catch (e: Exception) {
        println("exception => $e")
        //test00 + 1
        //return@mapIndexdNotNull null
    }

    println("volume = $volume")

}