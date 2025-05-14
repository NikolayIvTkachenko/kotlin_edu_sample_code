package org.example.algoriyhms

import java.util.*

fun main() {
    program7001()
}

fun program7001() {
    print("===> program7001 ")
    println()
    val stringArray = arrayOf("flower","flow","flight")
    var result = longestCommonPrefix(stringArray)
    println(result)
}

//Write a function to find the longest common prefix string amongst an array of strings.
//
//If there is no common prefix, return an empty string "".
//
//
//
//Example 1:
//
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
//Example 2:
//
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
//
//
//Constraints:
//
//1 <= strs.length <= 200
//0 <= strs[i].length <= 200
//strs[i] consists of only lowercase English letters if it is non-empty.

fun longestCommonPrefix(strs: Array<String>): String? {
    // Assume the first string is the starting prefix
    var prefix = strs[0]

    // Iterate through the rest of the strings
    for (i in 1 until strs.size) {
        // Keep trimming the prefix until it's a prefix of the current string
        while (strs[i].indexOf(prefix) != 0) {
            // Chop off the last character of the prefix
            prefix = prefix.substring(0, prefix.length - 1)

            // If the prefix becomes empty, there's no common prefix
            if (prefix.isEmpty()) {
                return ""
            }
        }
    }
    // Return the resulting common prefix
    return prefix
}

fun longestCommonPrefixV2(strs: Array<String>?): String? {
    if (strs == null || strs.size == 0) return ""
    Arrays.sort(strs)
    val first = strs[0]
    val last = strs[strs.size - 1]
    var c = 0
    while (c < first.length) {
        if (first[c] == last[c]) c++ else break
    }
    return if (c == 0) "" else first.substring(0, c)
}