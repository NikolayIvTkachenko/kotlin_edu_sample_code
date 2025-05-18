package org.example.algoriyhms

fun main() {
    program55001()
    program55002()
    program55003()
}

fun program55001() {
    println("===> program55001")
    println()
    //Input: arr = [2,1]
    //Output: false
    val arr = intArrayOf(2,1)
    println("arr = $arr")
    arr.map {
        print("$it ==> ")
    }
    println()
    val result = validMountainArray(arr)
    println("result =$result")
}

fun program55002() {
    println("===> program55002")
    println()
    //Input: arr = [3,5,5]
    //Output: false
    val arr = intArrayOf(3,5,5)
    println("arr = $arr")
    arr.map {
        print("$it ==> ")
    }
    println()
    val result = validMountainArray(arr)
    println("result =$result")
}

fun program55003() {
    println("===> program55003")
    println()
    //Input: arr = [0,3,2,1]
    //Output: true
    val arr = intArrayOf(0,3,2,1)
    println("arr = $arr")
    arr.map {
        print("$it ==> ")
    }
    println()
    val result = validMountainArray(arr)
    println("result =$result")

}

//Valid Mountain Array
//
//Given an array of integers arr, return true if and only if it is a valid mountain array.
//
//Recall that arr is a mountain array if and only if:
//
//arr.length >= 3
//There exists some i with 0 < i < arr.length - 1 such that:
//arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
//arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

//Example 1:
//
//Input: arr = [2,1]
//Output: false
//Example 2:
//
//Input: arr = [3,5,5]
//Output: false
//Example 3:
//
//Input: arr = [0,3,2,1]
//Output: true
//
//
//Constraints:
//
//1 <= arr.length <= 104
//0 <= arr[i] <= 104

//
//0 -> 2 -> 3 -> 4 -> 5 -> 2 -> 1 ->0
//
//0 -> 2 -> 3 -> -> 5 -> 2 -> 1 -> 0
//
//

fun validMountainArray(arr: IntArray): Boolean {
    val n = arr.size
    var i = 0
    if (n < 3) return false
    while (i + 1 < n && arr[i] < arr[i + 1]) {
        i++
    }
    if (i == 0 || i == n - 1) return false
    while (i + 1 < n && arr[i] > arr[i + 1]) {
        i++
    }
    return i == n - 1
}

fun validMountainArrayV2(arr: IntArray): Boolean {
    if (arr.size < 3) {
        return false
    }
    var i = 0
    while (i < arr.size - 1 && arr[i] < arr[i + 1]) {
        i++
    }
    if (i == 0 || i == arr.size - 1) {
        return false
    }
    while (i < arr.size - 1 && arr[i] > arr[i + 1]) {
        i++
    }
    return i == arr.size - 1
}


