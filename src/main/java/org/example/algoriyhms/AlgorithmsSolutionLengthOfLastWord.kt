package org.example.algoriyhms

fun main() {

    program49001()
    program49002()

}


//Given a string s consisting of words and spaces, return the length of the last word in the string.
//
//A word is a maximal substring consisting of non-space characters only.
//
//
//
//Example 1:
//
//Input: s = "Hello World"
//Output: 5
//Explanation: The last word is "World" with length 5.
//Example 2:
//
//Input: s = "   fly me   to   the moon  "
//Output: 4
//Explanation: The last word is "moon" with length 4.
//Example 3:
//
//Input: s = "luffy is still joyboy"
//Output: 6
//Explanation: The last word is "joyboy" with length 6.
//
//
//Constraints:
//
//1 <= s.length <= 104
//s consists of only English letters and spaces ' '.
//There will be at least one word in s.

fun program49001() {
    println("==> program49001")
    println()
    var s = "Hello World"
    println("s = $s")
    println()
    val result = lengthOfLastWord(s)
    println("result = $result")
    println()

}

fun program49002() {
    println("==> program49002")
    println()
    var s = "   fly me   to   the moon  "
    println("s = $s")
    println()
    val result = lengthOfLastWord(s)
    println("result = $result")
    println()

}

fun program49003() {
    println("==> program49003")
    println()
    var s = "luffy is still joyboy"
    println("s = $s")
    println()
    val result = lengthOfLastWord(s)
    println("result = $result")
    println()

}

fun lengthOfLastWord(s: String): Int {
    var s = s
    s = s.trim { it <= ' ' }
    var length = 0
    for (i in s.length - 1 downTo 0) {
        if (s[i] != ' ') {
            length++
        } else if (length > 0) {
            break
        }
    }
    return length
}

fun lengthOfLastWordV2(s: String): Int {
    var length = 0

    // We are looking for the last word so let's go backward
    for (i in s.length - 1 downTo 0) {
        if (s[i] != ' ') { // a letter is found so count
            length++
        } else {  // it's a white space instead
            //  Did we already started to count a word ? Yes so we found the last word
            if (length > 0) return length
        }
    }
    return length
}

fun lengthOfLastWordV3(s: String): Int {
    var count = 0
    for (i in s.length - 1 downTo 0) {
        if (s[i] == ' ' && count == 0) {
            continue
        } else if (s[i] == ' ' && count > 0) {
            break
        } else {
            count++
        }
    }
    return count
}