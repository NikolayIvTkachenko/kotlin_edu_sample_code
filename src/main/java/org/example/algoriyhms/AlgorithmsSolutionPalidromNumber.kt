package org.example.algoriyhms

fun main() {
    program3001()

}

fun program3001() {
    println("=========> program3001()")
    val num = 121
    print("$num is palidrom = ")
    println(isPalindrome(num))
    println()
    println()
    print("$num is palidrom = ")
    println(isPalindromeV2(num))

}

//Given an integer x, return true if x is a palindrome, and false otherwise.
//Example 1:
//
//Input: x = 121
//Output: true
//Explanation: 121 reads as 121 from left to right and from right to left.
//Example 2:
//
//Input: x = -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
//Example 3:
//
//Input: x = 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

fun isPalindrome(x: Int): Boolean {
    val s = x.toString() // Convert to String
    val n = s.length // Store the String length to int n
    for (i in 0 until n / 2) {
        // We check whether the elements at the same distance from
        // beginning and from ending are same, if not we return false
        if (s[i] != s[n - i - 1]) return false
    }

    // if no flaws are found we return true
    return true
}

fun isPalindromeV2(num: Int): Boolean {
    var x = num
    if (x < 0 || x != 0 && x % 10 == 0) return false
    var rev = 0
    println("x = $x")
    println("rev = $rev")
    println("start loop ==>")
    while (x > rev) {
        rev = rev * 10 + x % 10
        x = x / 10
        println("x = $x")
        println("rev = $rev")
    }
    println("after loop")
    println("x = $x")
    println("rev = $rev")
    return x == rev || x == rev / 10
}