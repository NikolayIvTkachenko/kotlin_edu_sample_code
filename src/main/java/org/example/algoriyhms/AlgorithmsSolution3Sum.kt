package org.example.algoriyhms

import java.util.*


fun main() {
    program62001()
    program62002()
    program62003()
}

fun program62001() {
    println("==> program62001")
    println()
    ////Input: nums = [-1,0,1,2,-1,-4]
    ////Output: [[-1,-1,2],[-1,0,1]]
    val inputNums = intArrayOf(-1,0,1,2,-1,-4)
    println("inputNums = $inputNums")
    println()
    val result = threeSum(inputNums)
    println("result = $result")
    println()

}

fun program62002() {
    println("==> program62002")
    println()
    //Input: nums = [0,1,1]
    //Output: []
    val inputNums = intArrayOf(0,1,1)
    println("inputNums = $inputNums")
    println()
    val result = threeSum(inputNums)
    println("result = $result")
    println()

}

fun program62003() {
    println("==> program62003")
    println()
    //Input: nums = [0,0,0]
    //Output: [[0,0,0]]
    val inputNums = intArrayOf(0,0,0)
    println("inputNums = $inputNums")
    println()
    val result = threeSum(inputNums)
    println("result = $result")
    println()


}

fun threeSum(nums: IntArray): List<List<Int>>? {
    Arrays.sort(nums)
    val res: MutableList<List<Int>> = ArrayList()
    for (i in nums.indices) {
        if (nums[i] > 0) break
        if (i > 0 && nums[i] == nums[i - 1]) continue
        var l = i + 1
        var r = nums.size - 1
        while (l < r) {
            val sum = nums[i] + nums[l] + nums[r]
            if (sum > 0) {
                r--
            } else if (sum < 0) {
                l++
            } else {
                res.add(Arrays.asList(nums[i], nums[l], nums[r]))
                l++
                r--
                while (l < r && nums[l] == nums[l - 1]) {
                    l++
                }
            }
        }
    }
    return res
}

//3Sum
//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
// and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//Notice that the solution set must not contain duplicate triplets.
//
//
//
//Example 1:
//
//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
//Explanation:
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//The distinct triplets are [-1,0,1] and [-1,-1,2].
//Notice that the order of the output and the order of the triplets does not matter.
//Example 2:
//
//Input: nums = [0,1,1]
//Output: []
//Explanation: The only possible triplet does not sum up to 0.
//Example 3:
//
//Input: nums = [0,0,0]
//Output: [[0,0,0]]
//Explanation: The only possible triplet sums up to 0.
//
//
//Constraints:
//
//3 <= nums.length <= 3000
//-105 <= nums[i] <= 105
//******************************
//Intuition
//The solution leverages the sorted nature of the array to efficiently find triplets that sum to zero.
//
//Sorting: Sorting allows us to use the two-pointer technique, which is much faster than checking all possible combinations of three numbers. It also makes it easier to skip duplicate numbers.
//
//Two-Pointer: The two-pointer technique efficiently explores all possible pairs of numbers (nums[l] and nums[r]) for a given first number (nums[i]). By moving the pointers based on whether the sum is too large or too small, we quickly narrow down the search space.
//
//Duplicate Handling: The conditions to skip duplicate numbers are essential for ensuring that the result list contains only unique triplets. Without this, the same triplet might be added multiple times.
//
//Efficiency: The algorithm has a time complexity of O(n^2), where n is the length of the array. The sorting step takes O(n log n), but the nested loops dominate the time complexity. This is significantly faster than the O(n^3) complexity of a brute-force approach that would check all possible combinations of three numbers.
//
//Approach
//The solution efficiently finds all unique triplets in a given array nums that sum up to zero. It employs a combination of sorting and a two-pointer technique:
//
//Sorting: The array nums is first sorted using Arrays.sort(nums). This is crucial for both the two-pointer technique and for efficiently handling duplicate triplets.
//
//Iteration: The code iterates through the sorted array using a for loop. The loop variable i represents the index of the first number in the potential triplet.
//
//Duplicate Handling (Outer Loop):
//
//The condition if (nums[i] > 0) break; is an optimization. If the current number nums[i] is positive, there's no possibility of finding a triplet that sums to zero because the array is sorted, and all subsequent numbers will also be positive.
//
//The condition if (i > 0 && nums[i] == nums[i - 1]) continue; skips duplicate numbers for the first element of the triplet. If the current number is the same as the previous one, we've already considered all possible triplets with that number as the first element, so we move on.
//
//Two-Pointer Technique: For each nums[i], two pointers, l and r, are initialized. l starts at i + 1, and r starts at the end of the array (nums.length - 1). These pointers define the remaining two numbers in the potential triplet.
//
//Sum Calculation and Adjustment:
//
//Inside the while (l < r) loop, the sum of the three numbers (nums[i], nums[l], and nums[r]) is calculated.
//
//If sum > 0, it means the sum is too large, so the right pointer r is decremented to consider a smaller number.
//
//If sum < 0, it means the sum is too small, so the left pointer l is incremented to consider a larger number.
//
//If sum == 0, a triplet is found. The triplet (nums[i], nums[l], nums[r]) is added to the result list res. Then, l is incremented, and r is decremented to search for other possible triplets.
//
//Duplicate Handling (Inner Loop):
//
//The while (l < r && nums[l] == nums[l - 1]) l++; loop skips duplicate numbers for the second element of the triplet. After finding a valid triplet, we move l to the next distinct number to avoid adding duplicate triplets to the result.
//Result: The res list, which contains all the unique triplets that sum to zero, is returned.
//
//Complexity
//Time complexity: O(n^2)
//Space complexity:
//O(1) or O(n) extra space depending on the sorting algorithm.
//O(m) space for the output list.
//*************************************

//****************************************
//Intuition
//The solution leverages the sorted nature of the array to efficiently find triplets that sum to zero.
//
//Sorting: Sorting allows us to use the two-pointer technique, which is much faster than checking all possible combinations of three numbers. It also makes it easier to skip duplicate numbers.
//
//Two-Pointer: The two-pointer technique efficiently explores all possible pairs of numbers (nums[l] and nums[r]) for a given first number (nums[i]). By moving the pointers based on whether the sum is too large or too small, we quickly narrow down the search space.
//
//Duplicate Handling: The conditions to skip duplicate numbers are essential for ensuring that the result list contains only unique triplets. Without this, the same triplet might be added multiple times.
//
//Efficiency: The algorithm has a time complexity of O(n^2), where n is the length of the array. The sorting step takes O(n log n), but the nested loops dominate the time complexity. This is significantly faster than the O(n^3) complexity of a brute-force approach that would check all possible combinations of three numbers.
//
//Approach
//The solution efficiently finds all unique triplets in a given array nums that sum up to zero. It employs a combination of sorting and a two-pointer technique:
//
//Sorting: The array nums is first sorted using Arrays.sort(nums). This is crucial for both the two-pointer technique and for efficiently handling duplicate triplets.
//
//Iteration: The code iterates through the sorted array using a for loop. The loop variable i represents the index of the first number in the potential triplet.
//
//Duplicate Handling (Outer Loop):
//
//The condition if (nums[i] > 0) break; is an optimization. If the current number nums[i] is positive, there's no possibility of finding a triplet that sums to zero because the array is sorted, and all subsequent numbers will also be positive.
//
//The condition if (i > 0 && nums[i] == nums[i - 1]) continue; skips duplicate numbers for the first element of the triplet. If the current number is the same as the previous one, we've already considered all possible triplets with that number as the first element, so we move on.
//
//Two-Pointer Technique: For each nums[i], two pointers, l and r, are initialized. l starts at i + 1, and r starts at the end of the array (nums.length - 1). These pointers define the remaining two numbers in the potential triplet.
//
//Sum Calculation and Adjustment:
//
//Inside the while (l < r) loop, the sum of the three numbers (nums[i], nums[l], and nums[r]) is calculated.
//
//If sum > 0, it means the sum is too large, so the right pointer r is decremented to consider a smaller number.
//
//If sum < 0, it means the sum is too small, so the left pointer l is incremented to consider a larger number.
//
//If sum == 0, a triplet is found. The triplet (nums[i], nums[l], nums[r]) is added to the result list res. Then, l is incremented, and r is decremented to search for other possible triplets.
//
//Duplicate Handling (Inner Loop):
//
//The while (l < r && nums[l] == nums[l - 1]) l++; loop skips duplicate numbers for the second element of the triplet. After finding a valid triplet, we move l to the next distinct number to avoid adding duplicate triplets to the result.
//Result: The res list, which contains all the unique triplets that sum to zero, is returned.
//
//Complexity
//Time complexity: O(n^2)
//Space complexity:
//O(1) or O(n) extra space depending on the sorting algorithm.
//O(m) space for the output list.
