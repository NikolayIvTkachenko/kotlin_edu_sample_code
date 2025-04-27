package org.example.algoriyhms

import java.lang.IllegalArgumentException

class Solutions {

    //Given an integer x, return true if x is a palidrome, and false otherwise
    fun isPalindrome(x: Int): Boolean {
        if(x < 0) return false
        var reversed = 0
        var number = x
        while (number !=0) {
              reversed = reversed * 10 + number % 10
            number /= 10
        }
        return reversed == x
    }



    fun getMapEachCaracter(s: String): Map<Char, List<Char>>  {
        val frequencies = s.groupBy { it }
        println(frequencies)

        return frequencies
    }

    fun firstUniqChar(s: String): Int {
        val frequencies = s.groupingBy { it }.eachCount()
        println(frequencies)
        s.forEachIndexed { index, c ->
            if (frequencies[c] == 1) {
                return index
            }
        }
        return -1
    }


    fun firstUniqCharV2(s: String): Int {
        val frequencies = s.groupBy { it } as LinkedHashMap
        println(frequencies)

        s.forEachIndexed { index, c ->
            //println(frequencies[c]?.size)
            if (frequencies[c]?.size == 1) return index
        }
        return -1
    }

    //You may assume that each input would have exactly one solution and you may noy  use the same element twice
    //You can return the answer in any order
    //Example 1
    //Input: nums = [2,7,11,15], target = 9
    //Output: [0, 1]
    //Explanation: Because nums[0] + nums[1] == 9, we return [0, 1]
    //Example 2
    //Inputs: nums = [3, 2, 4], target = 6
    //Output: [1, 2]
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for(item in nums.indices) {
            val complement = target - nums[item]
            if(map.containsKey(complement)) {
                return intArrayOf(map[complement]!!, item)
            }
            map[nums[item]] = item
        }
        throw IllegalArgumentException("No two elements add up to the target")
    }

}