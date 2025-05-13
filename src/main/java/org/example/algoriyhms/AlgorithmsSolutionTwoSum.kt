package org.example.algoriyhms

fun main() {
    program01()
    program02()
    program03()
}

fun program01() {
    println("---------------------->")
    var nums = intArrayOf(2, 7, 11, 15)
    var target = 9

    val result = twoSum(nums, target)
    println(result)
    result.map { item ->
        print("$item  ")
    }
    println("==>")
    if (result.size == 2) {
        println(nums[result[0]])
        println(nums[result[1]])
    }
}

fun program02() {
    println("---------------------->")
    var nums = intArrayOf(3, 2, 4)
    var target = 6

    val result = twoSum(nums, target)
    println(result)
    result.map { item ->
        print("$item  ")
    }
    println("==>")
    if (result.size == 2) {
        println(nums[result[0]])
        println(nums[result[1]])
    }
}


fun program03() {
    println("---------------------->")
    var nums = intArrayOf(3, 3)
    var target = 6

    val result = twoSum(nums, target)
    println(result)
    result.map { item ->
        print("$item  ")
    }
    println("==>")
    if (result.size == 2) {
        println(nums[result[0]])
        println(nums[result[1]])
    }
}


//Given an array of integers nums and an integer target,
// return indices of the two numbers such that they add up to target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//You can return the answer in any order.
//-------
//We need to find two numbers in the array that sum up to a given target.
// Instead of using a brute-force approach that checks all pairs (which would be too slow),
// we can leverage a hash table (dictionary) to store numbers we’ve seen so far and quickly
// check if their complement exists.
//Example 1:
//
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//Example 2:
//
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//Example 3:
//
//Input: nums = [3,3], target = 6
//Output: [0,1]

fun twoSum(nums: IntArray, target: Int): IntArray {
    println("====================================")
    val nMap = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        println(i)
        val complement = target - nums[i]
        println("complement = $complement ")
        println("nMap.containsKey(complement) = ${nMap.containsKey(complement)}")
        if (nMap.containsKey(complement)) {
            return intArrayOf(nMap[complement]!!, i)
        }
        nMap[nums[i]] = i
    }
    return intArrayOf()
}

