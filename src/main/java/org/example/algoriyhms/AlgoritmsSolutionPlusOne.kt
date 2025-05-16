package org.example.algoriyhms

fun main() {
    program11001()
    program11002()
}

fun program11001() {
    println("==> program11001()")
    println()
    val digits01 = intArrayOf(1, 2, 3)
    digits01.map { item ->
        print(" $item => ")
    }
    println("==============>")
    val result = plusOne(digits01)
    result?.map { item ->
        print(" $item => ")
    }
    println()
}

fun program11002() {
    println("==> program11002()")
    println()
    val digits01 = intArrayOf(4, 3, 2, 1)
    digits01.map { item ->
        print(" $item => ")
    }
    println("==============>")
    val result = plusOne(digits01)
    result?.map { item ->
        print(" $item => ")
    }
    println()

}

//You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
//
//Increment the large integer by one and return the resulting array of digits.
//
//
//
//Example 1:
//
//Input: digits = [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
//Incrementing by one gives 123 + 1 = 124.
//Thus, the result should be [1,2,4].
//Example 2:
//
//Input: digits = [4,3,2,1]
//Output: [4,3,2,2]
//Explanation: The array represents the integer 4321.
//Incrementing by one gives 4321 + 1 = 4322.
//Thus, the result should be [4,3,2,2].
//Example 3:
//
//Input: digits = [9]
//Output: [1,0]
//Explanation: The array represents the integer 9.
//Incrementing by one gives 9 + 1 = 10.
//Thus, the result should be [1,0].
//
//
//Constraints:
//
//1 <= digits.length <= 100
//0 <= digits[i] <= 9
//digits does not contain any leading 0's.

fun plusOneV3(digits: IntArray): IntArray? {
    var k = 1
    val ans = IntArray(digits.size)
    for (i in digits.indices.reversed()) {
        k += digits[i]
        ans[i] = k % 10
        k /= 10
    }
    if (k != 0) {
        val ans1 = IntArray(digits.size + 1)
        ans1[0] = 1
        return ans1
    }
    return ans
}
fun plusOneV2(digits: IntArray): IntArray {
    var size = digits.size
    for(i in size-1 downTo 0) {
        digits[i] = digits[i] + 1
        if (digits[i] == 10) digits[i] = 0
        else return digits
    }
    val newResult = IntArray(size+1)
    newResult[0] = 1
    return newResult
}

fun plusOne(digits: IntArray): IntArray? {
    val n = digits.size

    // Start from the last digit and go backwards
    for (i in n - 1 downTo 0) {
        // Add 1 to the current digit
        digits[i]++

        // If the digit becomes 10, set it to 0
        if (digits[i] == 10) {
            digits[i] = 0
        } else {
            // We added 1 successfully, no carry-over, so return the array
            return digits
        }
    }

    // If we reach here, it means all digits were 9
    // Create a new array with one extra digit
    val newDigits = IntArray(n + 1)

    // Set the first digit to 1 (the carry-over)
    newDigits[0] = 1

    // The rest of the digits are already 0 by default, so return the new array
    return newDigits
}