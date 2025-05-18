package org.example.algoriyhms

import java.util.*


fun main() {

    program59001()
    program59002()
    program59003()

}

fun program59001() {
    println("==> program59001")
    println()
    //Input: nums = [4,2,3], k = 1
    //Output: 5
    val k = 1
    val nums = intArrayOf(4,2,3)
    nums.map {
        print("$it ==>")
    }
    println()
    println("k = $k")
    println()
    val result = largestSumAfterKNegations(nums, k)
    println("result = $result")
    println()

}

fun program59002() {
    println("==> program59002")
    println()
    //Input: nums = [3,-1,0,2], k = 3
    //Output: 6
    val k = 3
    val nums = intArrayOf(3,-1,0,2)
    nums.map {
        print("$it ==>")
    }
    println()
    println("k = $k")
    println()
    val result = largestSumAfterKNegations(nums, k)
    println("result = $result")
    println()
}

fun program59003() {
    println("==> program59003")
    println()
    //Input: nums = [2,-3,-1,5,-4], k = 2
    //Output: 13
    val k = 2
    val nums = intArrayOf(2,-3,-1,5,-4)
    nums.map {
        print("$it ==>")
    }
    println()
    println("k = $k")
    println()
    val result = largestSumAfterKNegations(nums, k)
    println("result = $result")
    println()
}

//Максимизировать сумму массива ПОСЛЕ k ОТРИЦАНИЙ
//Maximize Sum Of Array AFTER k nEGATIONS
//Given an integer array nums and an integer k, modify the array in the following way:
//
//choose an index i and replace nums[i] with -nums[i].
//You should apply this process exactly k times. You may choose the same index i multiple times.
//
//Return the largest possible sum of the array after modifying it in this way.
//
//
//
//Example 1:
//
//Input: nums = [4,2,3], k = 1
//Output: 5
//Explanation: Choose index 1 and nums becomes [4,-2,3].
//Example 2:
//
//Input: nums = [3,-1,0,2], k = 3
//Output: 6
//Explanation: Choose indices (1, 2, 2) and nums becomes [3,1,0,2].
//Example 3:
//
//Input: nums = [2,-3,-1,5,-4], k = 2
//Output: 13
//Explanation: Choose indices (1, 4) and nums becomes [2,3,-1,5,4].
//
//
//Constraints:
//
//1 <= nums.length <= 104
//-100 <= nums[i] <= 100
//1 <= k <= 104
//********************
fun largestSumAfterKNegations(A: IntArray, K: Int): Int {
    var K = K
    Arrays.sort(A)
    var i = 0
    while (K > 0 && i < A.size && A[i] < 0) {
        A[i] = -A[i]
        ++i
        --K
    }
    var res = 0
    var min = Int.MAX_VALUE
    for (a in A) {
        res += a
        min = Math.min(min, a)
    }
    return res - K % 2 * min * 2
}

//Explanation
//@codePower:
//In case someone needs an explanation:
//1- sort the numbers in ascending order
//2- flip all the negative numbers, as long as k > 0
//3- find the sum of the new array (with flipped numbers if any) and keep track of the minimum number
//4- Now for the return statement
//
//res is the total sum of the new array
//K % 2 check if the remaining K is odd.
//
//Because if it's even, it will have no effect
//(we will flip a number and then get it back to the original)
//
//If it's odd,
//flip the minimum number and remove twice its value from the result
//(twice because we already added it as positive in our sum operation)
//
//
//Complexity
//Time O(NlogN) for sorting.
//Space O(1) extra space, in-place sort
//
//Time can be easily improved to O(N),
//by quick selecting the kth negative.

//***********
fun largestSumAfterKNegationsV2(A: IntArray, K: Int): Int {
    var K = K
    Arrays.sort(A)
    var sum = 0
    if (A[0] >= 0 && K % 2 != 0) {
        A[0] = -A[0]
    } else if (A[0] < 0) { //&& K % 2 == 0) {
        var change = 0
        while (K > 0 && A[change] < 0 && change < A.size) {
            A[change] = -A[change++]
            K--
        }
        if (K % 2 != 0) {
            val index = if (A[change] < A[change - 1]) change else change - 1
            A[index] = -A[index]
        }
    }
    for (`val` in A) sum += `val`
    return sum
}
//The intution is -
//
//Sort the array.
//Check if first element of the array is positive.
//i. If K is even, don't modify anything.
//ii. Else, modify the lowest element.
//Else, mark all -ve elements positive for a given K.
//If K after operations is not even then, mark the lowest element -ve.
//Sum up and return.