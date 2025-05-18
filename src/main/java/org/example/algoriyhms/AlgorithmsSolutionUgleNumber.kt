package org.example.algoriyhms

fun main() {

    program56001()
    program56002()
    program56003()

}

fun program56001() {
    println("==> program56001")
    println()
    var n = 6
    println()
    println("n= $n")
    var result = isUgly(n)
    println()
    println("result = $result")
    println()
}

fun program56002() {
    println("==> program56002")
    println()
    var n = 1
    println()
    println("n= $n")
    var result = isUgly(n)
    println()
    println("result = $result")
    println()

}

fun program56003() {
    println("==> program56003")
    println()
    var n = 14
    println()
    println("n= $n")
    var result = isUgly(n)
    println()
    println("result = $result")
    println()

}


//
//Ugly Number
//
//An ugly number is a positive integer which does not have a prime factor other than 2, 3, and 5.
//
//Given an integer n, return true if n is an ugly number.
//
//
//
//Example 1:
//
//Input: n = 6
//Output: true
//Explanation: 6 = 2 × 3
//Example 2:
//
//Input: n = 1
//Output: true
//Explanation: 1 has no prime factors.
//Example 3:
//
//Input: n = 14
//Output: false
//Explanation: 14 is not ugly since it includes the prime factor 7.
//
//
//Constraints:
//
//-231 <= n <= 231 - 1
//***********
//Intuition
//To determine if a number is an ugly number, we need to ensure that its prime factors are only 2, 3, or 5.
// If a number has any other prime factor, it is not considered ugly.
//
//Approach
//If the number n is less than or equal to 0, it is not an ugly number.
//Define an array of the prime factors we care about: [2, 3, 5].
//Iterate through each prime factor in the array.
//For each factor, divide the number n by that factor as long as n is divisible by it.
//After processing all the factors, if n is reduced to 1, it means n is an ugly number.
// If not, it is not an ugly number.
//Complexity
//Time complexity: The time complexity is O(logn) because we repeatedly divide n by 2, 3, and 5 until n becomes 1.
//Space complexity: The space complexity is O(1) because we are using a fixed amount
// of extra space (the array of factors).
//

fun isUgly(n: Int): Boolean {
    var n = n
    if (n <= 0) return false
    val factors = intArrayOf(2, 3, 5)
    for (factor in factors) {
        while (n % factor == 0) {
            n /= factor
        }
    }
    return n == 1
}