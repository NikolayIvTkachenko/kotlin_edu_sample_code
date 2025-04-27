package org.example

import org.example.algoriyhms.Solutions
import org.example.structures.stack.isValidParentheses

fun main() {

    //program001()
    program002()

}

fun program002() {
    println("((())))".isValidParentheses())
    println("(((())))".isValidParentheses())
}

fun program001() {
    val solutions = Solutions()
    println("Test 01 Integer is Polidrome")
    val result = solutions.isPalindrome(12233221)
    println(result)
    println()

    println("Test 02 The First uniq number ")
    val str01 = "hhello";
    val resultStr01 = solutions.firstUniqChar(str01)
    println(resultStr01)

    val resultStr02 = solutions.getMapEachCaracter(str01)
    println(resultStr02)

    println("Test 03 The First uniq number ")
    val resultStr03 = solutions.firstUniqCharV2(str01)
    println(resultStr03)

    println("Test 04 Two Sum")
    val nums = intArrayOf(2, 7, 11, 15)
    val target = 9
    val result05 = solutions.twoSum(nums, target)
    println(result05)
    result05.forEach { item -> print("$item ") }

    println("Test 05 Two Sum")
    val nums2 = intArrayOf(3, 2, 4)
    val target2 = 6
    val result06 = solutions.twoSum(nums2, target2)
    println(result06)
    result06.forEach { item -> print("$item ") }
}