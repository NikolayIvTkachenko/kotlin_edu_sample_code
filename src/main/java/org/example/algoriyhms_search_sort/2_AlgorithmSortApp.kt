package org.example.algoriyhms_search_sort

fun main() {
    programTimeTrackerSort()
}

fun programTimeTrackerSort() {
    val startTime = System.currentTimeMillis().toLong()

    // programSort001()
    // programSort002()
    // programSort003()
    // programSort004()
    // programSort005()
    programSort006()

    val stopTime = System.currentTimeMillis().toLong()
    val elapsedTime: Long = stopTime - startTime

    println("startTime = $startTime")
    println("stopTime = $stopTime")
    println("elapsedTime = $elapsedTime")
}

fun programSort001() {
    println("programSort001()")
    val numbers = arrayOf(8, 11, 9, 6, 10, 7, 2, 3, 1, 4, 5)
    println("before numbers = ${numbers.map { println(it) }}")
    println("=========")
    bubbleSort(numbers)
    println("after numbers = ${numbers.map { println(it) }}")
}

fun bubbleSort(numbers: Array<Int>) {
    println("bubbleSort")
    for (i in numbers.size - 1 downTo 1) {
        for (j in 0 until i) {
            if (numbers[j] > numbers[j + 1]) {
                var temp = numbers[j]
                numbers[j] = numbers[j + 1]
                numbers[j + 1] = temp
            }
        }
    }
}

fun programSort002() {
    println("programSort002()")
    val numbers = arrayOf(8, 11, 9, 6, 10, 7, 2, 3, 1, 4, 5)
    println("before numbers = ${numbers.map { println(it) }}")
    println("=========")
    bubbleSortV2(numbers)
    println("after numbers = ${numbers.map { println(it) }}")
}

fun bubbleSortV2(numbers: Array<Int>) {
    println("bubbleSortV2")
    for (i in numbers.size - 1 downTo 1) {
        var flag = false
        for (j in 0 until i) {
            if (numbers[j] > numbers[j + 1]) {
                var temp = numbers[j]
                numbers[j] = numbers[j + 1]
                numbers[j + 1] = temp
                flag = true
            }
        }
        if (!flag) return
    }
}

fun programSort003() {
    println("programSort003()")
    val numbers = arrayOf(8, 11, 9, 6, 10, 7, 2, 3, 1, 4, 5)
    println("before numbers = ${numbers.map { println(it) }}")
    println("=========")
    selectionSort(numbers)
    println("after numbers = ${numbers.map { println(it) }}")
}

fun selectionSort(numbers: Array<Int>) {
    println("selectionSort")
    for (i in numbers.size - 1 downTo 1) {
        var maxIndex = i

        for (j in 0 until i) {
            if (numbers[j] > numbers[maxIndex]) {
                maxIndex = j
            }
        }
        if (maxIndex != i) {
            var temp = numbers[maxIndex]
            numbers[maxIndex] = numbers[i]
            numbers[i] = temp
        }
    }
}


fun programSort004() {
    println("programSort004()")
    val numbers = arrayOf(8, 11, 9, 6, 10, 7, 2, 3, 1, 4, 5)
    println("before numbers = ${numbers.map { println(it) }}")
    println("=========")
    insertionSort(numbers)
    println("after numbers = ${numbers.map { println(it) }}")
}

fun insertionSort(numbers: Array<Int>) {
    println("insertionSort")
    var buffer = 0
    for (i in 1 until numbers.size) {
        buffer = numbers[i]
        var j = i
        while (j > 0 && numbers[j - 1] > buffer) {
            numbers[j] = numbers[j - 1]
            j--
        }
        numbers[j] = buffer
    }
}

fun programSort005() {
    println("programSort005()")
    val numbers = arrayOf(8, 11, 9, 6, 10, 7, 2, 3, 1, 4, 5)
    println("before numbers = ${numbers.map { println(it) }}")
    println("=========")
    countSort(numbers)
    //println("after numbers = ${numbers.map { println(it) }}")
}

fun countSort(numbers: Array<Int>) {
    println("countSort")
    var k = 20 //Ширина используемого диапазона
    var count: Array<Int> = Array(k) { 0 }

    for (i in 0 .. numbers.size) {
        count[i] = count[i] + 1
    }

    for(i in 0 until k) {
        for (j in 0 until count[i]) {
            println(" $i \" \" ")
        }
    }
}

fun programSort006() {
    println("programSort006()")
    val numbers = arrayOf(8, 11, 9, 6, 10, 7, 2, 3, 1, 4, 5)
    println("before numbers = ${numbers.map { println(it) }}")
    println("=========")
    radixSort(numbers)
    println("after numbers = ${numbers.map { println(it) }}")
}

fun radixSort(numbers: Array<Int>) {
    println("radixSort")
    var digitCounts = 10
    var maxLengthOfNumber = 9
    var p = 1 //степень 10

    var pocket: Array<ArrayList<Int>> = Array(digitCounts) { ArrayList<Int>() } // массив для распределения элементов по корзинам

    for (i in 0 until maxLengthOfNumber) {

        for (j in numbers.indices) {
            var index = (numbers[j] / p) % 10 //находим интдекс карзины
            pocket[index].add(numbers[j])
        }
        var count = 0
        for (j in 0 until digitCounts) {
            for(k in 0 until pocket[j].size) {
                numbers[count] = pocket[j][k]
                count++
            }
            pocket[j].clear()
        }
        p *= 10
    }
}