package org.example.algoriyhms

fun main() {
    program5001()
    //program5002()
}

fun program5001() {
    println()
    println("=========> program5001")
    val nums = intArrayOf(0,0,1,1,1,2,2,3,3,4)
    println("before: ")
    nums.map { item ->
        print(" $item  ")
    }
    println()
    var result = removeDuplicates(nums)
    println(result)
    println("after: ")
    nums.map { item ->
        print(" $item  ")
    }
}

fun program5002() {
    println()
    println("=========> program5002")
    val nums = intArrayOf(1,1,2)
    println()
    var result = removeDuplicatesV2(nums)
    println(result)
    nums.map { item ->
        print(" $item  ")
    }
}

//Given an integer array nums sorted in non-decreasing order,
// remove the duplicates in-place such that each unique element appears only once.
// The relative order of the elements should be kept the same. Then return the number
// of unique elements in nums.
//
//Consider the number of unique elements of nums to be k, to get accepted,
// you need to do the following things:
//
//Change the array nums such that the first k elements of nums contain the
// unique elements in the order they were present in nums initially.
// The remaining elements of nums are not important as well as the size of nums.
//Return k.
//Example 1:
//
//Input: nums = [1,1,2]
//Output: 2, nums = [1,2,_]
//Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
//It does not matter what you leave beyond the returned k (hence they are underscores).
//Example 2:
//
//Input: nums = [0,0,1,1,1,2,2,3,3,4]
//Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
//Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
//It does not matter what you leave beyond the returned k (hence they are underscores).

//Нарушается порядок//удовлетворяет постановке задачи
fun removeDuplicatesV2(nums: IntArray): Int {
    var i = if (nums.isNotEmpty()) 1 else 0
    for (n in nums)
        if (n > nums[i - 1]) nums[i++] = n
    return i
}


//Нарушается порядок//удовлетворяет постановке задачи
fun removeDuplicates(nums: IntArray): Int {
    var i = 0
    for (n in nums) {
        println("n = $n")
        println("i = $i")

        if (i == 0 || n > nums[i - 1]){
            //println("nums[i - 1] = ${nums[i - 1]}")
            nums[i++] = n
            println("nums[i++] = ${nums[i]}")
        }
    }
//    nums.map { item ->
//        print(" $item  ")
//    }
    return i
}

//Нарушается порядок//удовлетворяет постановке задачи
fun removeDuplicatesV3(nums: IntArray): Int {
    println("==> removeDuplicatesV3")
    println()
    if (nums.isEmpty()) return 0
    var i = 0
    for (j in 1 until nums.size) {
        if (nums[j] != nums[i]) {
            i++
            nums[i] = nums[j]
        }
    }
    nums.map { item ->
        print(" $item  ")
    }
    println()
    return i + 1
}