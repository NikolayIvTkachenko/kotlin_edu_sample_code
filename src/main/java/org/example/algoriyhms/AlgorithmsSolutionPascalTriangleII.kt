package org.example.algoriyhms


fun main() {

    program52001()
    program52002()
    program52003()

}

//Pascal Triangle II
//Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
//
//In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
//Example 1:
//
//Input: rowIndex = 3
//Output: [1,3,3,1]
//Example 2:
//
//Input: rowIndex = 0
//Output: [1]
//Example 3:
//
//Input: rowIndex = 1
//Output: [1,1]
//
//
//Constraints:
//
//0 <= rowIndex <= 33


//******************************************************************************
//                      1
//                    1   1
//                  1   2   1
//                1   3   3   1
//              1   4   6   4   1
//******************************************************************************

fun program52001() {
    println("==> program52001")
    println()
    var numRows = 3
    println("numRows = $numRows")
    println()
    var result = getRow(numRows)
    println("result = $result")
    println()

}

fun program52002() {
    println("==> program52002")
    println()
    var numRows = 0
    println("numRows = $numRows")
    println()
    var result = getRow(numRows)
    println("result = $result")
    println()

}

fun program52003() {
    println("==> program52003")
    println()
    var numRows = 1
    println("numRows = $numRows")
    println()
    var result = getRow(numRows)
    println("result = $result")
    println()

}

fun getRow(rowIndex: Int): List<Int>? {
    val res: MutableList<Int> = ArrayList()
    var cnt: Long = 1
    res.add(cnt.toInt())
    for (i in 1..rowIndex) {
        cnt = cnt * (rowIndex + 1 - i) / i
        res.add(cnt.toInt())
    }
    return res
}

fun getRowV2(rowIndex: Int): List<Int>? {
    val triangle: MutableList<List<Int>> = ArrayList()
    for (i in 0..rowIndex) {
        val row: MutableList<Int> = ArrayList()
        for (j in 0..i) {
            if (j == 0 || j == i) {
                row.add(1) // The first and last elements in each row are 1.
            } else {
                val prevRow = i - 1
                val leftVal = triangle[prevRow][j - 1]
                val rightVal = triangle[prevRow][j]
                row.add(leftVal + rightVal) // Sum of the two numbers above.
            }
        }
        triangle.add(row)
    }
    return triangle[rowIndex]
}