package org.example.algoriyhms

fun main() {
    program26001()
    program26002()
}

fun program26001() {
    println("==> program2600")
    println()
    val nums = intArrayOf(3,2,2,3)
    val target = 3
    println("nums = $nums")
    nums.map {
        print(" $it ==> ")
    }
    println()
    val result = removeElementV4(nums, target)
    println("resuly = $result")
    println()
    println("after nums = $nums")
    nums.map {
        print(" $it ==> ")
    }
}


fun program26002() {
    println("==> program2600")
    println()
    val nums = intArrayOf(0,1,2,2,3,0,4,2)
    val target = 2
    println("nums = $nums")
    nums.map {
        print(" $it ==> ")
    }
    println()
    val result = removeElementV4(nums, target)
    println("resuly = $result")
    println()
    println("after nums = $nums")
    nums.map {
        print(" $it ==> ")
    }
}


//Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
// The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
//
//Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
//
//Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
// The remaining elements of nums are not important as well as the size of nums.
//Return k.
//Custom Judge:
//
//The judge will test your solution with the following code:
//
//int[] nums = [...]; // Input array
//int val = ...; // Value to remove
//int[] expectedNums = [...]; // The expected answer with correct length.
//                            // It is sorted with no values equaling val.
//
//int k = removeElement(nums, val); // Calls your implementation
//
//assert k == expectedNums.length;
//sort(nums, 0, k); // Sort the first k elements of nums
//for (int i = 0; i < actualLength; i++) {
//    assert nums[i] == expectedNums[i];
//}
//If all assertions pass, then your solution will be accepted.
//
//
//
//Example 1:
//
//Input: nums = [3,2,2,3], val = 3
//Output: 2, nums = [2,2,_,_]
//Explanation: Your function should return k = 2, with the first two elements of nums being 2.
//It does not matter what you leave beyond the returned k (hence they are underscores).
//Example 2:
//
//Input: nums = [0,1,2,2,3,0,4,2], val = 2
//Output: 5, nums = [0,1,4,0,3,_,_,_]
//Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
//Note that the five elements can be returned in any order.
//It does not matter what you leave beyond the returned k (hence they are underscores).

//Constraints:
//
//0 <= nums.length <= 100
//0 <= nums[i] <= 50
//0 <= val <= 100

//Approach
//I am using Two pointers method
//After shifting the val to the right side of the array.
//Just return the value of k which is length of array excluding val.
//Complexity
//Time complexity:O(n)
//Space complexity:O(1)

fun removeElement(nums: IntArray, sampleValue: Int): Int {
    var i = 0
    for (j in nums.indices) {
        if (nums[j] != sampleValue) {
            val temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
            i++
        }
    }
    return i
}

fun removeElementV2(nums: IntArray, sampleValue: Int): Int {
    var p = 0
    val len = nums.size - 1
    var i = 0
    while (i < len + 1) {
        if (nums[i] == sampleValue) {
            nums[i] = nums[len - p]
            nums[len - p] = '_'.code
            p++
            i--
        }
        i++
    }
    return nums.size - p
}

fun removeElementV3(nums: IntArray, sampleValue: Int): Int {
    var count = 0
    for (i in nums.indices) {
        if (nums[i] != sampleValue) {
            nums[count++] = nums[i]
        }
    }
    return count
}

fun removeElementV4(nums: IntArray, sampleValue: Int): Int {
    println("==> removeElementV4")
    println("==> nums.indices = ${nums.indices}")
    var count = 0
    println("==> for (i in nums.indices) --> ")
    for (i in nums.indices) {
        println("i = $i")
        println("==> nums[i] = ${nums[i]}")
        println("==> sampleValue = ${sampleValue}")

        if (nums[i] != sampleValue) {
//            val n = count++
//            println("nums[n] = ${nums[n]}")
//            println("nums[i] = ${nums[i]}")
//            nums[n] = nums[i]
            nums[count++] = nums[i]
        }
    }
    println("count = $count")
    return count
}