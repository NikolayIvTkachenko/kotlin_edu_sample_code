package org.example.algoriyhms

fun main() {
    program60001()
    program60002()
    program60003()
}

fun program60001() {
    println("==> program60001")
    println()
    val num = 123
    ///Input: num = 123
    //Output: "One Hundred Twenty Three"
    println()
    println("num = $num")
    println()
    val result = numberToWords(num)
    println("result = $result")
    println()
}

fun program60002() {
    println("==> program60002")
    println()
    val num = 12345
    //Input: num = 12345
    //Output: "Twelve Thousand Three Hundred Forty Five"
    println()
    println("num = $num")
    println()
    val result = numberToWords(num)
    println("result = $result")
    println()
}


fun program60003() {
    println("==> program60003")
    println()
    val num = 1234567
    //Input: num = 1234567
    //Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
    println()
    println("num = $num")
    println()
    val result = numberToWords(num)
    println("result = $result")
    println()
}


//Convert a non-negative integer num to its English words representation.
//
//
//
//Example 1:
//
//Input: num = 123
//Output: "One Hundred Twenty Three"
//Example 2:
//
//Input: num = 12345
//Output: "Twelve Thousand Three Hundred Forty Five"
//Example 3:
//
//Input: num = 1234567
//Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
//
//
//Constraints:
//
//0 <= num <= 231 - 1

private val belowTwenty = arrayOf(
    "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
    "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
)
private val tens = arrayOf("", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")

fun numberToWords(num: Int): String? {
    return if (num == 0) {
        "Zero"
    } else helper(num)
}

private fun helper(num: Int): String? {
    val result = StringBuilder()
    if (num < 20) {
        result.append(belowTwenty[num])
    } else if (num < 100) {
        result.append(tens[num / 10]).append(" ").append(belowTwenty[num % 10])
    } else if (num < 1000) {
        result.append(helper(num / 100)).append(" Hundred ").append(helper(num % 100))
    } else if (num < 1000000) {
        result.append(helper(num / 1000)).append(" Thousand ").append(helper(num % 1000))
    } else if (num < 1000000000) {
        result.append(helper(num / 1000000)).append(" Million ").append(helper(num % 1000000))
    } else {
        result.append(helper(num / 1000000000)).append(" Billion ").append(helper(num % 1000000000))
    }
    return result.toString().trim { it <= ' ' }
}