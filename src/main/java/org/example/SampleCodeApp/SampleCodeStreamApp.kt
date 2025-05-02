package org.example.SampleCodeApp

fun main() {
    //programSample001()
    programSample002()
}



fun programSample001() {
    val letters = listOf("a", "b", "c", "D")
    val results = mutableListOf<String>()

    results.addAll(letters.map {
        it.toUpperCase()
    })

    results.addAll(letters.map {
        it.toLowerCase()
    })

    println(results)
}

fun programSample002() {
    val letters = listOf("a", "b", "c", "D")
    val results = mutableListOf<String>()

    letters.mapTo(results) {
        it.toUpperCase()
    }

    letters.mapTo(results) {
        it.toLowerCase()
    }

    println(results)
}