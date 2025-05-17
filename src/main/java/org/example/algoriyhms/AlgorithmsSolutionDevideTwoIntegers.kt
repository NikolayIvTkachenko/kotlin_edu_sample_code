package org.example.algoriyhms

fun main() {

    program48001()
    program48002()

}

//Devide Two Integers
//Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
//
//The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
//
//Return the quotient after dividing dividend by divisor.
//
//Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.
//
//
//
//Example 1:
//
//Input: dividend = 10, divisor = 3
//Output: 3
//Explanation: 10/3 = 3.33333.. which is truncated to 3.
//Example 2:
//
//Input: dividend = 7, divisor = -3
//Output: -2
//Explanation: 7/-3 = -2.33333.. which is truncated to -2.
//
//
//Constraints:
//
//-231 <= dividend, divisor <= 231 - 1
//divisor != 0

fun program48001() {
    println("==> program48001")
    println()
    var dividend = 10
    var divisor = 3
    println("dividend = $dividend")
    println("divisor = $divisor")
    val result = divide(dividend, divisor)
    println()
    println("result =$result")
    println()
    println()
}

fun program48002() {
    println("==> program48002")
    println()
    var dividend = 7
    var divisor = -3
    println("dividend = $dividend")
    println("divisor = $divisor")
    val result = divide(dividend, divisor)
    println()
    println("result =$result")
    println()
}

fun divide(a: Int, b: Int): Int {
    var a = a
    var b = b
    if (b == 1) {
        return a
    }
    if (a == Int.MIN_VALUE && b == -1) {
        return Int.MAX_VALUE
    }
    val sign = a > 0 && b > 0 || a < 0 && b < 0
    a = if (a > 0) -a else a
    b = if (b > 0) -b else b
    var ans = 0
    while (a <= b) {
        var x = b
        var cnt = 1
        while (x >= Int.MIN_VALUE shr 1 && a <= x shl 1) {
            x = x shl 1
            cnt = cnt shl 1
        }
        ans += cnt
        a -= x
    }
    return if (sign) ans else -ans
}

fun divideV2(dividend: Int, divisor: Int): Int {
    // Handle edge cases for overflow
    if (dividend == Int.MIN_VALUE && divisor == -1) {
        return Int.MAX_VALUE // Clamp to 2^31 - 1
    }
    if (dividend == Int.MIN_VALUE && divisor == 1) {
        return Int.MIN_VALUE // Clamp to -2^31
    }

    // Determine the sign of the result
    val isNegative = (dividend < 0) xor (divisor < 0) // XOR: true if signs differ

    // Convert dividend and divisor to positive values
    var absDividend = Math.abs(dividend.toLong()) // Use long to handle edge cases
    val absDivisor = Math.abs(divisor.toLong())
    var result = 0

    // Perform division using bit manipulation
    while (absDividend >= absDivisor) {
        var tempDivisor = absDivisor
        var multiple = 1

        // Double the divisor until it exceeds the remaining dividend
        while (absDividend >= tempDivisor shl 1) {
            tempDivisor = tempDivisor shl 1
            multiple = multiple shl 1
        }

        // Subtract the largest shifted divisor and add the corresponding multiple
        absDividend -= tempDivisor
        result += multiple
    }

    // Apply the sign to the result
    return if (isNegative) -result else result
}

//*****************
//Approach
//Handle Signs: Determine the sign of the result based on the signs of the dividend and divisor. A negative result occurs if only one of them is negative.
//Convert to Absolute Values: Since the problem is easier to solve with positive numbers, take the absolute values of both the dividend and divisor.
//Bitwise Optimization:
//Instead of repeatedly subtracting the divisor, use the fact that multiplying the divisor by powers of 2 (via left shifts) allows us to subtract larger chunks at a time.
//For example, if divisor is 3, consider subtracting 3, 6, 12, ... (powers of 2 times the divisor) from dividend.
//Subtract Powers of 2:
//Start with the largest possible multiple of the divisor (using shifts).
//Subtract it from the dividend and update the quotient accordingly.
//Clamp the Result: Ensure the result fits within the 32-bit signed integer range [-2^31, 2^31 - 1].
//****************
//Example Walkthrough
//Input:
//dividend = 10
//divisor = 3
//Steps:
//Sign Calculation:
//dividend > 0, divisor > 0 → isNegative = false.
//Absolute Values:
//absDividend = 10, absDivisor = 3.
//Division Using Shifts:
//Start with tempDivisor = 3, multiple = 1.
//Shift tempDivisor left (tempDivisor = 6, multiple = 2) → 10 >= 6.
//Subtract 6 from 10 → absDividend = 4, result = 2.
//Repeat for remaining absDividend = 4:
//tempDivisor = 3, multiple = 1 → 4 >= 3.
//Subtract 3 → absDividend = 1, result = 3.
//Apply Sign:
//Result is positive → return 3.
//Output:
//3.
//*********************

