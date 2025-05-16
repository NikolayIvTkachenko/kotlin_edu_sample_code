package org.example.algoriyhms

fun main() {

    program16001()
    program16002()

}

fun program16001() {
    println("===> program16001")
    println()
    val n = 2
    val result =  climbingStairs(n)
    println("result = $result")
    println()

    val resultV2 =  climbingStairsV2(n)
    println("resultV2 = $resultV2")
    println()
}

fun program16002() {
    println("===> program16002")
    println()
    val n = 3
    val result =  climbingStairs(n)
    println("result = $result")
    println()
    val resultV2 =  climbingStairsV2(n)
    println("resultV2 = $resultV2")
    println()
}

fun climbingStairsV2(step: Int): Int {
    if (step == 0 || step == 1) {
        return 1
    }
    return climbingStairsV2(step - 1) + climbingStairsV2(step - 2)
}

fun climbingStairs(step: Int): Int {
    if (step == 0 || step == 1)
        return 1
    var prev = 1
    var curr = 1
    for (i in 2..step) {
        var temp = curr
        curr = prev + curr
        prev = temp
    }
    return curr
}



//You are climbing a staircase. It takes n steps to reach the top.
//
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
//
//
//Example 1:
//
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
//Example 2:
//
//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
//
//
//Constraints:
//
//1 <= n <= 45

///Explanation: The recursive solution uses the concept of
// Fibonacci numbers to solve the problem. It calculates the number of
// ways to climb the stairs by recursively calling the climbStairs function
// for (n-1) and (n-2) steps. However, this solution has exponential time complexity (O(2^n))
// due to redundant calculations.