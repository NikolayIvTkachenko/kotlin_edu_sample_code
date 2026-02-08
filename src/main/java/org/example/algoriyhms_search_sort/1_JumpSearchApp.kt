package org.example.algoriyhms_search_sort

import kotlin.math.sqrt

fun main() {
    programTimeTrackerJumpSearch()
}

fun programTimeTrackerJumpSearch() {
    val startTime = System.currentTimeMillis().toLong()

    // programJumpSearch001()
    programJumpSearch002()

    val stopTime = System.currentTimeMillis().toLong()
    val elapsedTime: Long = stopTime - startTime

    println("startTime = $startTime")
    println("stopTime = $stopTime")
    println("elapsedTime = $elapsedTime")
}

fun programJumpSearch001() {
    val numbers = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    val key = 5
    println("numbers = $numbers")
    println("key = $key")
    val result = jumpSearch(numbers, key)
    println("result = $result")
}

fun jumpSearch(numbers: Array<Int>, key: Int): Int {
    val b = sqrt(numbers.size.toDouble()).toInt()

    var start = 0
    var end = b - 1

    while (numbers[end] < key) {
        if (end == numbers.size - 1) break
        start = Math.min(numbers.size - 1, start + b)
        end = Math.min(numbers.size - 1, end + b)

        if (key > numbers[end]) return -1
    }

    for (i in end downTo start ) {
        if (numbers[i] == key) return i
    }

    return -1
}

fun programJumpSearch002() {
    val numbers = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    val key = 5
    println("numbers = $numbers")
    println("key = $key")
    val result = jumpSearchV2(numbers, key)
    println("result = $result")
}

fun jumpSearchV2(numbers: Array<Int>, key: Int): Int {
    val b = sqrt(numbers.size.toDouble()).toInt()

    var start = 0
    var end = b - 1

    while (numbers[end] <= key  && end < numbers.size - 1 && numbers[end+1] <= key) {
        start = Math.min(numbers.size - 1, start + b)
        end = Math.min(numbers.size - 1, end + b)

        if (key > numbers[end]) return -1
    }

    for (i in end downTo start ) {
        if (numbers[i] == key) return i
    }

    return -1
}
