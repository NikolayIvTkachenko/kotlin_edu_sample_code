package org.example.algoriyhms

fun main() {
    program17001()
    program17002()
}

fun program17001() {
    println("===> program17001")
    println()
    val n = 4
    val result = operationSqrt(n)
    println("n = $n")
    println("result = $result")
    println()

}

fun program17002() {
    println("===> program17002")
    println()
    val n = 8
    val result = operationSqrt(n)
    println("n = $n")
    println("result = $result")
    println()
}

fun operationSqrt(x: Int): Int {
    if (x == 0) {
        return 0
    }
    var first = 1
    var last = x
    while (first <= last) {
        val mid = first + (last - first) / 2
        if (mid == x / mid) {
            return mid
        } else if (mid > x / mid) {
            last = mid - 1
        } else {
            first = mid + 1
        }
    }
    return last
}

//Approach for this Problem:
//If x is 0, return 0.
//Initialize first to 1 and last to x.
//While first is less than or equal to last, do the following:
//a. Compute mid as first + (last - first) / 2.
//b. If mid * mid equals x, return mid.
//c. If mid * mid is greater than x, update last to mid - 1.
//d. If mid * mid is less than x, update first to mid + 1.
//Return last.

//Given a non-negative integer x, return the square root of x rounded down
// to the nearest integer. The returned integer should be non-negative as well.
//
//You must not use any built-in exponent function or operator.
//
//For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
//
//
//Example 1:
//
//Input: x = 4
//Output: 2
//Explanation: The square root of 4 is 2, so we return 2.
//Example 2:
//
//Input: x = 8
//Output: 2
//Explanation: The square root of 8 is 2.82842...,
// and since we round it down to the nearest integer, 2 is returned.