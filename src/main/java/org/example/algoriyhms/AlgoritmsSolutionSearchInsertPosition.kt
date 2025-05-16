package org.example.algoriyhms

fun main() {

    program190001()
    program190002()
    program190003()

}

fun program190001() {
    println("===> program190001")
    println()
    val arr = intArrayOf(1, 3, 5, 6)
    val target = 5
    val result = searchInsert(arr, target)
    println("result = $result")
    println()
}

fun program190002() {
    println("===> program190001")
    println()
    val arr = intArrayOf(1, 3, 5, 6)
    val target = 2
    val result = searchInsert(arr, target)
    println("result = $result")
    println()
}

fun program190003() {
    println("===> program190001")
    println()
    val arr = intArrayOf(1, 3, 5, 6)
    val target = 7
    val result = searchInsert(arr, target)
    println("result = $result")
    println()
}

//Search Insert Position
//Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//
//You must write an algorithm with O(log n) runtime complexity.
//
//
//
//Example 1:
//
//Input: nums = [1,3,5,6], target = 5
//Output: 2
//Example 2:
//
//Input: nums = [1,3,5,6], target = 2
//Output: 1
//Example 3:
//
//Input: nums = [1,3,5,6], target = 7
//Output: 4
//
//
//Constraints:
//
//1 <= nums.length <= 104
//-104 <= nums[i] <= 104
//nums contains distinct values sorted in ascending order.
//-104 <= target <= 104

//We can apply binary search to efficiently find the correct position for the target:
//
//Use two pointers, l (left) and r (right), to represent the current search range.
//
//Calculate the middle index mid in the range and compare the value at mid with the target.
//
//If nums[mid] == target, return mid.
//If nums[mid] < target, move the left pointer to mid + 1.
//If nums[mid] > target, move the right pointer to mid - 1.
//Once the loop ends, if the target is not found, return l,
// which represents the position where the target should be inserted.

fun searchInsert(nums: IntArray, target: Int): Int {
    var l = 0
    var r = nums.size - 1
    while (l <= r) {
        val mid = l + (r - l) / 2
        if (nums[mid] == target) return mid
        else if (nums[mid] < target) l = mid + 1
        else r = mid - 1
    }
    return l
}