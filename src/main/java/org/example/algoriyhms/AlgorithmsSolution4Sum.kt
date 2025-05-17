package org.example.algoriyhms

import java.util.*


fun main() {

    program45001()
    program45002()

}

//4Sum
//Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
//
//0 <= a, b, c, d < n
//a, b, c, and d are distinct.
//nums[a] + nums[b] + nums[c] + nums[d] == target
//You may return the answer in any order.
//
//
//
//Example 1:
//
//Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//Example 2:
//
//Input: nums = [2,2,2,2,2], target = 8
//Output: [[2,2,2,2]]
//
//
//Constraints:
//
//1 <= nums.length <= 200
//-109 <= nums[i] <= 109
//-109 <= target <= 109

fun program45001() {
    println("==> program45001")
    println()
    //nums = [1,0,-1,0,-2,2], target = 0
    val nums = intArrayOf(1,0,-1,0,-2,2)
    val target = 0
    println()
    nums.map {
        print("$it ==> ")
    }
    println()
    println("target = $target")
    println()
    val result = fourSum(nums, target)
    result?.map { items ->
        items.map { item ->
            print("$item ==> ")
        }
    }
    println()
    println()
}


fun program45002() {
    println("==> program45002")
    println()
    //nums = [2,2,2,2,2], target = 8
    val nums = intArrayOf(2,2,2,2,2)
    val target = 8
    println()
    nums.map {
        print("$it ==> ")
    }
    println()
    println("target = $target")
    println()
    val result = fourSum(nums, target)
    result?.map { items ->
        items.map { item ->
            print("$item ==> ")
        }
    }
    println()
    println()
}

fun fourSumV2(nums: IntArray, target: Int): List<List<Int>>? {
    Arrays.sort(nums)
    val s: MutableSet<List<Int>> = HashSet()
    val output: MutableList<List<Int>> = ArrayList()
    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            var k = j + 1
            var l = nums.size - 1
            while (k < l) {
                var sum = nums[i].toLong()
                sum += nums[j].toLong()
                sum += nums[k].toLong()
                sum += nums[l].toLong()
                if (sum == target.toLong()) {
                    s.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]))
                    k++
                    l--
                } else if (sum < target) {
                    k++
                } else {
                    l--
                }
            }
        }
    }
    output.addAll(s)
    return output
}

fun fourSum(nums: IntArray?, target: Int): List<List<Int>>? {
    val li: MutableList<List<Int>> = ArrayList()
    if (nums == null || nums.size < 4) {
        return li
    }
    Arrays.sort(nums)
    for (i in 0 until nums.size - 3) {
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue
        }
        for (j in i + 1 until nums.size - 2) {
            if (j > i + 1 && nums[j] == nums[j - 1]) {
                continue
            }
            var left = j + 1
            var right = nums.size - 1
            while (left < right) {
                val sum = nums[i].toLong() + nums[j] + nums[left] + nums[right]
                if (sum == target.toLong()) {
                    li.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]))
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++
                    }
                    while (left < right && nums[right] == nums[right + -1]) {
                        right--
                    }
                    left++
                    right--
                } else if (sum < target) {
                    left++
                } else {
                    right--
                }
            }
        }
    }
    return li
}

//Approach
//Check Array Length:
//First, check if the length of the input array is less than 4. If yes, return an empty array or list because we can't form a valid group of 4 elements.
//
//Sort the Array:
//Sort the array in ascending order. Sorting helps us manage duplicates and makes it easier to work with combinations.
//
//Find Unique Combinations:
//Use a loop to go through the array and look for groups of 4 numbers. While looping, skip any duplicates by using an if condition to check if the current number is the same as the previous one.
//
//Store Results:
//For each valid group of 4 numbers without duplicates, add it to the result list.
//
//Return the Result:
//After completing the loops, return the list of unique combinations.
//
//Complexity
//Time complexity:O(n3)
//Space complexity:O(k)
