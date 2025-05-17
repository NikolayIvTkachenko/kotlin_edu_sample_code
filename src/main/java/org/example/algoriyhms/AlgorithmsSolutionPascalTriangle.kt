package org.example.algoriyhms


fun main() {
    program50001()
    program50002()
}

fun program50001() {
    println("==> program50001")
    println()
    var numRows = 5
    println("numRows = $numRows")
    println()
    val result = generate(numRows)
    println("result = $result")
    println()

}

fun program50002() {
    println("==> program50002")
    println()
    var numRows = 1
    println("numRows = $numRows")
    println()
    val result = generate(numRows)
    println("result = $result")
    println()

}


//******************************************************************************
//                      1
//                    1   1
//                  1   2   1
//                1   3   3   1
//              1   4   6   4   1
//******************************************************************************

//Pascal Triangle
//Given an integer numRows, return the first numRows of Pascal's triangle.
//
//In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

//Example 1:
//
//Input: numRows = 5
//Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//Example 2:
//
//Input: numRows = 1
//Output: [[1]]
//
//
//Constraints:
//
//1 <= numRows <= 30
//*******************************************************************************
//Intuition
//To generate Pascal's Triangle, notice that each number is the sum of the two numbers directly above it. The first and last elements of each row are always 1. With this pattern in mind, we can build the triangle row by row.
//
//Approach
//We start with an empty list triangle and build each row from top to bottom. For each row:
//
//The first and last elements are 1.
//
//Each inner element is the sum of the two elements above it from the previous row.
//This method avoids calculating factorials and is efficient in both time and space.
//
//Complexity
//Time complexity:O(n^2)
//n is the number of rows. This is because we're filling every value of Pascal's Triangle up to numRows.
//
//Space complexity: O(n^2)
//for storing the result, as we're returning a list of lists containing all elements of the triangle.

fun generate(numRows: Int): List<List<Int>>? {
    val triangle: MutableList<List<Int>> = ArrayList()
    for (row in 0 until numRows) {
        val currentRow: MutableList<Int> = ArrayList()
        for (col in 0..row) {
            if (col == 0 || col == row) {
                currentRow.add(1)
            } else {
                val valueSample = triangle[row - 1][col - 1] + triangle[row - 1][col]
                currentRow.add(valueSample)
            }
        }
        triangle.add(currentRow)
    }
    return triangle
}