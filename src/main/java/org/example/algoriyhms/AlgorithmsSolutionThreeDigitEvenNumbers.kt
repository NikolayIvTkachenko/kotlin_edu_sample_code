package org.example.algoriyhms

fun main() {
    //program10001()
    program10002()
    //program10003()
}

fun program10001() {
    println("===> program10001")
    println()
    var digits = intArrayOf(2,1,3,0)

    val result = threeDigitEventNumberV1(digits)
    println()
    println(result)
    println()
    result.map { item ->
        print(" $item => ")
    }
}


fun program10002() {
    println("===> program10002")
    println()
    var digits = intArrayOf(2,2,8,8,2)

    val result = threeDigitEventNumberV2(digits)
    result.map { item ->
        print(" $item => ")
    }
}

fun program10003() {
    println("===> program10003")
    println()
    var digits = intArrayOf(3,7,5)

    val result = threeDigitEventNumberV1(digits)
    result.map { item ->
        print(" $item => ")
    }
}


//You are given an integer array digits, where each element is a digit. The array may contain duplicates.
//
//You need to find all the unique integers that follow the given requirements:
//
//The integer consists of the concatenation of three elements from digits in any arbitrary order.
//The integer does not have leading zeros.
//The integer is even.
//For example, if the given digits were [1, 2, 3], integers 132 and 312 follow the requirements.
//
//Return a sorted array of the unique integers.
//
//Example 1:
//
//Input: digits = [2,1,3,0]
//Output: [102,120,130,132,210,230,302,310,312,320]
//Explanation: All the possible integers that follow the requirements are in the output array.
//Notice that there are no odd integers or integers with leading zeros.
//Example 2:
//
//Input: digits = [2,2,8,8,2]
//Output: [222,228,282,288,822,828,882]
//Explanation: The same digit can be used as many times as it appears in digits.
//In this example, the digit 8 is used twice each time in 288, 828, and 882.
//Example 3:
//
//Input: digits = [3,7,5]
//Output: []
//Explanation: No even integers can be formed using the given digits.

fun threeDigitEventNumberV1(digits: IntArray): IntArray {
    // Time O(N) and Space O(1) where N is the length of digits.
    val digitFreq = IntArray(10)
    for (digit in digits) {
        print("$digit ")
        digitFreq[digit]++
    }
    println(digitFreq)
    digitFreq.map { item ->
        print(" $item => ")
    }

    val result = mutableListOf<Int>()

    for (msd in 1..<10) {
        //Исключаем в массиве отсутсвующие значения или равные 0
        if (digitFreq[msd] == 0) {
            continue
        }

        var value = msd * 100
        digitFreq[msd]--
        for (mid in 0..<10) {
            if(digitFreq[mid] == 0) {
                continue
            }
            value += mid * 10
            digitFreq[mid]--
            for(lsd in 0..<10 step 2) {
                if(digitFreq[lsd] == 0) {
                    continue
                }
                result.add(value + lsd)
            }
            digitFreq[mid]++
            value -= mid * 10
        }
        digitFreq[msd]++
    }
    return result.toIntArray()
}


val result = ArrayList<Int>()
fun threeDigitEventNumberV2(digits: IntArray): IntArray {

    val count = IntArray(10)
    for (d in digits) {
        count[d]++
    }
    dfs(0, count, 0)
    return IntArray(result.size) {
        result.get(it)
    }
}

private fun dfs(i: Int, count: IntArray, number: Int) {
    if (i == 3) {
        if (number and 1 == 0) result.add(number)
        return
    }
    val n10 = number * 10
    val min = if (i == 0) 1 else 0
    for (d in min..9) {
        if (count[d] > 0) {
            count[d]--
            dfs(i + 1, count, n10 + d)
            count[d]++
        }
    }
}