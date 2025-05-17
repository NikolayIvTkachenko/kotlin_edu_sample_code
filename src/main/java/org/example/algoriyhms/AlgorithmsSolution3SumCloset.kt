package org.example.algoriyhms

import java.util.*


fun main() {

    program46001()
    program46002()

}

//3Sum Closest
//Given an integer array nums of length n and an integer target, find three integers in
// nums such that the sum is closest to target.
//
//Return the sum of the three integers.
//
//You may assume that each input would have exactly one solution.
//
//
//
//Example 1:
//
//Input: nums = [-1,2,1,-4], target = 1
//Output: 2
//Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
//Example 2:
//
//Input: nums = [0,0,0], target = 1
//Output: 0
//Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
//
//
//Constraints:
//
//3 <= nums.length <= 500
//-1000 <= nums[i] <= 1000
//-104 <= target <= 104

//Intuition
//Approach
//Complexity
//Time complexity:
//O(N^2)
//Space complexity:
//O(1)

fun program46001() {
    println("==> program46001")
    println()
    val nums = intArrayOf(-1,2,1,-4)
    val target = 1
    println()
    println()
    println("target = $target")
    val results = threeSumClosest(nums, target)
    println(results)
    println()
}

fun program46002() {
    println("==> program46001")
    println()
    val nums = intArrayOf(0,0,0)
    val target = 1
    println()
    println()
    println("target = $target")
    val results = threeSumClosest(nums, target)
    println(results)
    println()

}

fun threeSumClosest(nums: IntArray, target: Int): Int {
    Arrays.sort(nums)
    var closestSum = nums[0] + nums[1] + nums[2] // Initialize closest sum with the sum of the first three elements
    for (i in 0 until nums.size - 2) {
        var j = i + 1
        var k = nums.size - 1
        while (j < k) {
            val sum = nums[i] + nums[j] + nums[k]
            if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                closestSum = sum // Update closest sum if the current sum is closer to the target
            }
            if (sum < target) {
                j++ // Increment j to increase the sum
            } else {
                k-- // Decrement k to decrease the sum
            }
        }
    }
    return closestSum
}