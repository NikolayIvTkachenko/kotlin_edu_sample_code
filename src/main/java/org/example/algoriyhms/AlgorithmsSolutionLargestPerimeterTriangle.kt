package org.example.algoriyhms

import java.util.*


fun main() {

    program57001()
    program57002()

}

fun program57001() {
    println("==> program57001")
    println()
    //Input: nums = [2,1,2]
    //Output: 5
    val nums = intArrayOf(2,1,2)
    nums.map {
        print("$it => ")
    }
    println()
    println()
    val result = largestPerimeter(nums)
    println("result = $result")
    println()

}

fun program57002() {
    println("==> program57002")
    println()
    //Input: nums = [1,2,1,10]
    //Output: 0
    val nums = intArrayOf(1,2,1,10)
    nums.map {
        print("$it => ")
    }
    println()
    println()
    val result = largestPerimeter(nums)
    println("result = $result")
    println()

}


//Largest Perimeter Triangle
//Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.
//
//
//
//Example 1:
//
//Input: nums = [2,1,2]
//Output: 5
//Explanation: You can form a triangle with three side lengths: 1, 2, and 2.
//Example 2:
//
//Input: nums = [1,2,1,10]
//Output: 0
//Explanation:
//You cannot use the side lengths 1, 1, and 2 to form a triangle.
//You cannot use the side lengths 1, 1, and 10 to form a triangle.
//You cannot use the side lengths 1, 2, and 10 to form a triangle.
//As we cannot use any three side lengths to form a triangle of non-zero area, we return 0.
//
//
//Constraints:
//
//3 <= nums.length <= 104
//1 <= nums[i] <= 106

//Complexity
//Time complexity: O(nlogn)
//Space complexity: O(1)

fun largestPerimeter(nums: IntArray): Int {
    Arrays.sort(nums)
    val n = nums.size
    for (i in n - 1 downTo 2) {
        if (nums[i - 2] + nums[i - 1] > nums[i]) {
            return nums[i - 2] + nums[i - 1] + nums[i]
        }
    }
    return 0
}