package org.example.algoriyhms

fun main() {
    program120001()
    program120002()
}

fun program120001() {
    println("===> program120001")
    println()
    var a = "11"
    var b = "1"
    val result = addBinaryV2(a, b)
    println("a = $a")
    println("b = $b")
    println("result = $result")

}

fun program120002() {
    println("===> program120002")
    println()
    var a = "1010"
    var b = "1011"
    val result = addBinary(a, b)
    println("a = $a")
    println("b = $b")
    println("result = $result")

}

//Given two binary strings a and b, return their sum as a binary string.
//
//
//
//Example 1:
//
//Input: a = "11", b = "1"
//Output: "100"
//Example 2:
//
//Input: a = "1010", b = "1011"
//Output: "10101"
//
//
//Constraints:
//
//1 <= a.length, b.length <= 104
//a and b consist only of '0' or '1' characters.
//Each string does not contain leading zeros except for the zero itself.


//Use a.toString(2) where a is an Int, 2 is the radix

fun addBinaryV2(a: String, b: String): String? {


    return null
}

fun addBinary(a: String, b: String): String? {
    val sb = StringBuilder()
    var i = a.length - 1
    var j = b.length - 1
    var carry = 0
    while (i >= 0 || j >= 0) {
        var sum = carry
        if (j >= 0) sum += b[j--].code - '0'.code
        if (i >= 0) sum += a[i--].code - '0'.code
        sb.append(sum % 2)
        carry = sum / 2
    }
    if (carry != 0) sb.append(carry)
    return sb.reverse().toString()
}