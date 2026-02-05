package org.example.algoriyhms_search_sort

fun main() {

    programTimeTrackerLinearSearch()

}

fun programTimeTrackerLinearSearch() {
    val startTime = System.currentTimeMillis().toLong()

    // programLinearSearch001()
    // programLinearSearch002()
    // programLinearSearch003()
    programLinearSearch004()


    val stopTime = System.currentTimeMillis().toLong()
    val elapsedTime: Long = stopTime - startTime

    println("startTime = $startTime")
    println("stopTime = $stopTime")
    println("elapsedTime = $elapsedTime")
}

fun programLinearSearch001() {
    val numbers = arrayOf(8, 11, 9, 6, 10, 7, 2, 3, 1, 4, 5)
    val key = 2
    println("numbers = $numbers")
    println("key = $key")
    val result = LinearySearch(numbers, key)

    println("result = $result")
}

fun LinearySearch(numbers: Array<Int>, key: Int): Boolean {
    println("Lineary Search")
    for (i in numbers.indices) {
        if (numbers[i] == key) return true
    }
    return false
}

fun programLinearSearch002() {
    println("Binary Search")
    val numbers = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    val key = 8
    val resultIndex = BinarySearch(numbers, key)
    println("resultIndex = $resultIndex")
    println("numbers[resultIndex] = ${numbers[resultIndex]}")
}

fun BinarySearch(numbers: Array<Int>, key: Int): Int {
    println("BinarySearch")
    var left = 0
    var right = numbers.size - 1
    println("key = $key")
    println("left = $left")
    println("right = $right")

    while (left <= right) {
        var m = left + (right - left) / 2
        if (numbers[m] == key) return m
        if (numbers[m] < key) left = m + 1
        else right = m - 1
    }
    return -1
}

fun programLinearSearch003() {
    val numbers = arrayOf(8, 11, 9, 6, 10, 7, 2, 3, 1, 4, 5)
    val key = 2
    println("numbers = $numbers")
    println("key = $key")
    val result = LeftBinarySearch(numbers, key)
    println("result = $result")
}

fun LeftBinarySearch(numbers: Array<Int>, key: Int): Int {
    println("LeftBinarySearch")
    var left = -1
    var right = numbers.size - 1

    while (left + 1 < right) {
        var m = left + (right - left) / 2
        if (numbers[m] < key) left = m
        else right = m
    }
    if (numbers[right] == key) return  right
    return  -1
}

fun programLinearSearch004() {
    val numbers = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    val key = 2
    println("numbers = $numbers")
    println("key = $key")
    val result = RightBinarySearch(numbers, key)
    println("result = $result")
}

fun RightBinarySearch(numbers: Array<Int>, key: Int): Int {
    println("RightBinarySearch")
    var left = 0
    var right = numbers.size

    while (left + 1 < right) {
        val m = left + (right - left) / 2
        if (numbers[m] <= key) left = m
        else right = m
    }

    if (numbers[left] == key) return left
    return -1
}