package org.example.algoriyhms

fun main() {
    program41001()
    program41002()
    program41003()
}

fun program41001() {
    println("==> program41001")
    println()
    val nums =  intArrayOf(2,2,1) //[2,2,1]
    println()
    println(" nums = $nums")
    nums.map {
        print(" $it ==> ")
    }
    var result = singleNumber(nums)
    println()
    println("resilt = $result")
    println()
    println()
}

fun program41002() {
    println("==> program41002")
    println()
    val nums =  intArrayOf(4,1,2,1,2) //[4,1,2,1,2]
    println()
    println(" nums = $nums")
    nums.map {
        print(" $it ==> ")
    }
    var result = singleNumber(nums)
    println()
    println("resilt = $result")
    println()
    println()
}

fun program41003() {
    println("==> program41003")
    println()
    val nums =  intArrayOf(1) //[1]
    println()
    println(" nums = $nums")
    nums.map {
        print(" $it ==> ")
    }
    var result = singleNumber(nums)
    println()
    println("resilt = $result")
    println()
    println()
}

fun singleNumber(nums: IntArray): Int {
    var result = 0
    for (i in nums.indices) {
        result = result xor nums[i]
    }
    return result
}

fun singleNumberV2(nums: IntArray): Int {
    var ans = 0 //since XOR with 0 returns same number
    for (i in nums.indices) {
        ans = ans xor nums[i] // ans = (ans) XOR (array element at i)
    }
    return ans
}

fun singleNumberV3(arr: IntArray): Int {
    var xor = 0
    for (i in arr.indices) {
        xor = xor xor arr[i]
    }
    return xor
}

//Intuition
//XOR property could be used
//-> a^a = 0
//-> 0^a = a
//
//Approach
//treaverse -> xor each element -> only the single element would be left, rest all would pair up and give zero.
//Complexity
//Time complexity: O(n)
//Space complexity: O(1), no extra space used

//Имея корни двух бинарных деревьев p и q, напишите функцию для проверки их идентичности.
//
//Два бинарных дерева считаются одинаковыми, если они структурно идентичны, а узлы имеют одинаковое значение.
//
//Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
//
//You must implement a solution with a linear runtime complexity and use only constant extra space.
//
//
//Example 1:
//
//Input: nums = [2,2,1]
//
//Output: 1
//
//Example 2:
//
//Input: nums = [4,1,2,1,2]
//
//Output: 4
//
//Example 3:
//
//Input: nums = [1]
//
//Output: 1
//
//
//
//Constraints:
//
//1 <= nums.length <= 3 * 104
//-3 * 104 <= nums[i] <= 3 * 104
//Each element in the array appears twice except for one element which appears only once.
//
//*******************************************************************************************************************//
//Approach
//Using Bit Manipulation -
//
//As we know XOR operation with 0 gives the same number
//i.e, a XOR 0 = a
//eg, for decimal no. 2=> 2 XOR 0 = 2
//in binary, 010 XOR 000 = 010
//
//Also we know that , XOR operation with same number gives 0
//i.e, a XOR a = 0
//eg, 2 XOR 2 = 0
//in binary, 010 XOR 010 = 000
//
//XOR is associative (like sum)
//i.e, (2 XOR 3) XOR 4 = 2 XOR (3 XOR 4), So the order doesn't matter in performing XOR operation.
//eg, 2^3^4^6 = 3^2^6^4 = 4^2^6^3 ......
//
//So, using these three properties of XOR , we will solve the question.
// we will take ans variable with 0 as initial value. And then for each element i in array,
// we will perform the XOR operation of the element with 0, ans will become 0 if the same number
// is found (as a XOR a = 0) and so after the completion of the loop, only
// element with no duplicate number will remain and will be returned as ans.
//*******************************************************************************************************************//
//
//
//
