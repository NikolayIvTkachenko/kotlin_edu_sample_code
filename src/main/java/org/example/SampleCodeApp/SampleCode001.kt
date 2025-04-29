package org.example.SampleCodeApp

fun main() {
    program001()



}

fun program001() {
    val word = "Word";
    println()
    for(i in 0..(word.length-1)) {
        print("${word[i]} ")
    }
    println()
    for(i in 0..<word.length) {
        print("${word[i]} ")
    }
    println()
    for(element in word) {
        print("$element ")
    }
    println()

    for(i in 0 until word.length) {
        print("${word[i]} ")
    }
    println()

    for(i in (word.length-1) downTo 0) {
        print("${word[i]} ")
    }
    println()
    println("===")

    println(word.reversed())

}

public inline fun String.reversed(): String {
    return (this as CharSequence).reversed().toString()
}