package org.example.algoriyhms

import java.util.*

fun main() {

    program43001()
    program43002()
    program43003()

}

//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
//
//Given a string s, return true if it is a palindrome, or false otherwise.
//
//Example 1:
//
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
//Example 2:
//
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
//Example 3:
//
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric characters.
//Since an empty string reads the same forward and backward, it is a palindrome.
//
//
//Constraints:
//
//1 <= s.length <= 2 * 105
//s consists only of printable ASCII characters.

//******************************************************************************************************************//
//Approach
//The Problem: Valid Palindrome
//
//The task is to check if a given string is a palindrome.
// A palindrome is a string that reads the same forwards and backward, ignoring spaces,
// punctuation, and capitalization.
//
//For example:
//
//"A man, a plan, a canal: Panama" is a palindrome.
//"race a car" is not a palindrome.
//The Code Explained:
//
//******************************************************************************************************************//

fun program43001() {
    println("==> program43001")
    println()
    var str = "A man, a plan, a canal: Panama"
    println("str = $str")
    println()
    val result = isPalindrome(str)
    println("result = $result")
    println()
}

fun program43002() {
    println("==> program43002")
    println()
    var str = "race a car"
    println("str = $str")
    println()
    val result = isPalindrome(str)
    println("result = $result")
    println()
    println()
}

fun program43003() {
    println("==> program43003")
    println()
    var str = " "
    println("str = $str")
    println()
    val result = isPalindrome(str)
    println("result = $result")
    println()
}

fun isPalindrome(s: String): Boolean {
    // 1. Clean the string (remove non-alphanumeric characters and convert to lowercase)
    val cleanedString = s.replace("[^a-zA-Z0-9]".toRegex(), "")
        .lowercase(Locale.getDefault()) // Replace all non-alphanumeric characters with empty string and convert to lowercase

    // 2. Two-pointer approach (two pointers, one from the beginning, one from the end)
    var left = 0 // Pointer at the beginning of the string
    var right = cleanedString.length - 1 // Pointer at the end of the string

    // 3. Compare characters from both ends (compare until the pointers meet)
    while (left < right) { // Continue as long as the left pointer is before the right pointer
        if (cleanedString[left] != cleanedString[right]) { // If the characters at the pointers are different
            return false // It's not a palindrome
        }
        left++ // Move the left pointer to the right
        right-- // Move the right pointer to the left
    }

    // 4. If the loop finishes, it's a palindrome
    return true // If we reach the end, it's a palindrome
}