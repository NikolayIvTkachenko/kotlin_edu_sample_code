package org.example.algoriyhms

import java.util.*


fun main() {
    program32001()
    program32002()
    program32003()
}

fun program32001() {
    println("==> program32001")
    println()
    //nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    val nums1 = intArrayOf(1,2,3,0,0,0)
    val m = 3
    val nums2 = intArrayOf(2,5,6)
    val n = 3
    mergeV1(nums1, m, nums2, n)
    println()
    println("nums1.size = ${nums1.size} ")
    nums1.map {
        print(" $it ==>  ")
    }
    println()
    println()
}

fun program32002() {
    println("==> program32002")
    println()
    //nums1 = [1], m = 1, nums2 = [], n = 0
    val nums1 = intArrayOf(1)
    val m = 1
    val nums2 = intArrayOf()
    val n = 0
    mergeV1(nums1, m, nums2, n)
    println()
    println("nums1.size = ${nums1.size} ")
    nums1.map {
        print(" $it ==>  ")
    }
    println()
    println()
}

fun program32003() {
    println("==> program32003")
    println()
    //nums1 = [0], m = 0, nums2 = [1], n = 1
    val nums1 = intArrayOf(0)
    val m = 0
    val nums2 = intArrayOf(1)
    val n = 1
    mergeV1(nums1, m, nums2, n)
    println()
    println("nums1.size = ${nums1.size} ")
    nums1.map {
        print(" $it ==>  ")
    }
    println()
    println()
}


fun mergeV1(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    var j = 0
    var i = m
    while (j < n) {
        nums1[i] = nums2[j]
        i++
        j++
    }
    Arrays.sort(nums1)
}

//Merge Sorted Array
//Объединение отсортированного массива
//You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
//representing the number of elements in nums1 and nums2 respectively.
//
//Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//
//The final sorted array should not be returned by the function, but instead be stored inside the
// array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements
// that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
//
//
//Example 1:
//
//Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//Output: [1,2,2,3,5,6]
//Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
//Example 2:
//
//Input: nums1 = [1], m = 1, nums2 = [], n = 0
//Output: [1]
//Explanation: The arrays we are merging are [1] and [].
//The result of the merge is [1].
//Example 3:
//
//Input: nums1 = [0], m = 0, nums2 = [1], n = 1
//Output: [1]
//Explanation: The arrays we are merging are [] and [1].
//The result of the merge is [1].
//Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
//
//
//Constraints:
//
//nums1.length == m + n
//nums2.length == n
//0 <= m, n <= 200
//1 <= m + n <= 200
//-109 <= nums1[i], nums2[j] <= 109

//Approach : Using STL
//Traverse through nums2 and append its elements to the end of nums1 starting from index m.
//Sort the entire nums1 array using sort() function.
//Complexity
//Time complexity: O((m+n)log(m+n))
//due to the sort() function
//
//Space complexity: O(1)
//We are not using any extra space, so the space complexity is O(1).