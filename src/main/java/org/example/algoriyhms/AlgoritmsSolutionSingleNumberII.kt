package org.example.algoriyhms

fun main() {

    program44001()
    program44002()

}

//Single Number II
//
//Given an integer array nums where every element appears three times except for one,
// which appears exactly once. Find the single element and return it.
//
//You must implement a solution with a linear runtime complexity and use only constant extra space.
//
//
//
//Example 1:
//
//Input: nums = [2,2,3,2]
//Output: 3
//Example 2:
//
//Input: nums = [0,1,0,1,0,1,99]
//Output: 99
//
//
//Constraints:
//
//1 <= nums.length <= 3 * 104
//-231 <= nums[i] <= 231 - 1
//Each element in nums appears exactly three times except for one element which appears once.

fun program44001() {
    println("==> program44001")
    println()
    val nums = intArrayOf(2,2,3,2)
    println()
    nums.map {
        print(" $it ==> ")
    }
    var result = singleNumbeII(nums)
    println()
    println("result = $result")
    println()

}


fun program44002() {
    println("==> program44002")
    println()
    val nums = intArrayOf(0,1,0,1,0,1,99)
    println()
    nums.map {
        print(" $it ==> ")
    }
    var result = singleNumbeII(nums)
    println()
    println("result = $result")
    println()

}

fun singleNumbeII(nums: IntArray): Int {
    var ones = 0
    var twos = 0
    for (x in nums) {
        ones = ones xor x and twos.inv() // Update ones with bits seen once
        twos = twos xor x and ones.inv() // Update twos with bits seen twice
    }
    return ones // The single number appears only once
}

//Мы использовали побитовые операции для имитации подсчета каждого бита по модулю 3.
// Две переменные единицы и двойки отслеживают биты, которые появились один и
// два раза соответственно. Когда бит появляется третий раз, он очищается из обоих.
// Это позволяет нам изолировать битовый шаблон, который появляется ровно один раз.

//Time complexity: O(n) — Traversed the array once.
//Space complexity: O(1) — Constant amount of space used.

fun singleNumberIIV2(nums: IntArray): Int {
    var ones = 0
    var twos = 0
    for (num in nums) {
        ones = ones xor num and twos.inv()
        twos = twos xor num and ones.inv()
    }
    return ones
}


//Intuition
//Since every number appears three times except one, we can’t use a hash map due to space constraints.
//Instead, we use bitwise operations to track the count of each bit modulo 3.
//Using two variables ones and twos, we simulate a finite-state machine to count bits.
//
//Approach
//We use:
//
//ones to hold bits that have appeared once so far,
//twos to hold bits that have appeared twice.
//For each number x in the array:
//
//We update ones with the bits that appear the first time (and are not already in twos).
//Then update twos with the bits that appear the second time (and are not already in ones).
//If a bit appears the third time, it will be cleared from both ones and twos.
//
//After processing all numbers, only the unique number (which appears once) remains in ones.

//Complexity
//Time complexity: O(n)
//We iterate through the array once.
//
//Space complexity: O(1)
//We use only two integer variables regardless of input size.