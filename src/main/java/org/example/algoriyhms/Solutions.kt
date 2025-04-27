package org.example.algoriyhms

import java.lang.IllegalArgumentException
import kotlin.math.max

class ListNode(var valueSample: Int) {
    var next: ListNode? = null
}

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

    fun majorityElement(nums: IntArray): Int {
        var result = Int.MIN_VALUE
        nums.fold(mutableMapOf<Int, Int>()) {
            map, i -> map[i] = map.getOrDefault(i, 0) + 1
            result = max(result, map[i]!!)
            map
        }
        return result
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


    //You are given two non-empty linked lists representing two non-negative integers.
    // The digits are stored in reverse order, and each of their nodes contains a single digit.
    // Add the two numbers and return the sum as a linked list.
    //You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    //Input: l1 = [2,4,3], l2 = [5,6,4]
    //Output: [7,0,8]
    //Explanation: 342 + 465 = 807.
    //Example 2:
    //
    //Input: l1 = [0], l2 = [0]
    //Output: [0]
    //Example 3:
    //
    //Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    //Output: [8,9,9,9,0,0,0,1]
    //
    //
    //Constraints:
    //
    //The number of nodes in each linked list is in the range [1, 100].
    //0 <= Node.val <= 9
    //It is guaranteed that the list represents a number that does not have leading zeros.

    //var li = ListNode(5)
    //var v = li.valueSample

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var temp = dummy
        var carry = 0

        var l1Current = l1
        var l2Current = l2

        while (l1Current != null || l2Current != null || carry != 0) {
            val val1 = l1Current?.valueSample ?: 0
            val val2 = l2Current?.valueSample ?: 0

            val sum = val1 + val2 + carry
            carry = sum / 10
            temp.next = ListNode(sum % 10)
            temp = temp.next!!

            l1Current = l1Current?.next
            l2Current = l2Current?.next
        }

        return dummy.next
    }


}