package org.example.algoriyhms

import java.util.*


fun main() {
    program6001()
    program6002()
    program6003()
}

fun program6001() {
    println("===> program6001")
    println()
    val s = "()"
    var result = isValidParenthesis(s)
    println(result)
    println()
}

fun program6002() {
    println("===> program6001")
    println()
    val s = "()[]{}"
    var result = isValidParenthesis(s)
    println(result)
    println()

}

fun program6003() {
    println("===> program6001")
    println()
    val s = "(]"
    var result = isValidParenthesis(s)
    println(result)
    println()

}

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Every close bracket has a corresponding open bracket of the same type.
//
//
//Example 1:
//
//Input: s = "()"
//
//Output: true
//
//Example 2:
//
//Input: s = "()[]{}"
//
//Output: true
//
//Example 3:
//
//Input: s = "(]"
//
//Output: false
//
//Example 4:
//
//Input: s = "([])"
//
//Output: true
//
//

fun isValidParenthesis(s: String): Boolean {
    // Create hashmap to store the pairs...
    val Hmap = HashMap<Char, Char>()
    Hmap[')'] = '('
    Hmap['}'] = '{'
    Hmap[']'] = '['
    // Create stack data structure...
    val stack: Stack<Char> = Stack<Char>()
    // Traverse each charater in input string...
    for (idx in 0 until s.length) {
        // If open parentheses are present, push it to stack...
        if (s[idx] == '(' || s[idx] == '{' || s[idx] == '[') {
            stack.push(s[idx])
            continue
        }
        // If the character is closing parentheses, check that the same type opening parentheses is being pushed to the stack or not...
        // If not, we need to return false...
        if (stack.size === 0 || Hmap[s[idx]] !== stack.pop()) {
            return false
        }
    }
    // If the stack is empty, return true...
    return if (stack.size === 0) {
        true
    } else false
}

fun isValidParenthesisV2(s: String): Boolean {

    // Create a new stack to store the characters.
    val stack: Stack<Char> = Stack()


    // convert string into char array and access the characters using for each loop.
    for (ch in s.toCharArray()) {
        // check ch
        when (ch) {
            '(', '{', '[' -> stack.push(ch)
            ')' -> if (stack.isEmpty() || stack.pop() !== '(') // if the stack is empty then it means string have no open bracket.
            // hence it is invalid.
            {
                return false
            }

            '}' -> if (stack.isEmpty() || stack.pop() !== '{') {
                return false
            }

            ']' -> if (stack.isEmpty() || stack.pop() !== '[') {
                return false
            }
        }
    }

    // After the loop we have to check one more condition.
    // return true only if the stack is empty.
    // if stack is not empty that means we have unused brackets.
    return stack.isEmpty()
}