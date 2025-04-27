package org.example

import org.example.algoriyhms.ListNode
import org.example.algoriyhms.Solutions
import org.example.structures.linkedList.Node
import org.example.structures.stack.isValidParentheses
import org.example.structures.tree.TreeNodeV0

fun main() {

    //program001()
    //program002()
    //program003()
    //program004()
    //program005()

    //program006()
    //program007()

    //program008()
    program009()
}

fun program009() {
    //Input: l1 = [2,4,3], l2 = [5,6,4]
    //Output: [7,0,8]
    val solutions = Solutions()
    var ln011 = ListNode(2)
    var ln012 = ListNode(4)
    var ln013 = ListNode(3)
    ln011.next = ln012
    ln012.next = ln013

    var ln021 = ListNode(5)
    var ln022 = ListNode(6)
    var ln023 = ListNode(4)
    ln021.next = ln022
    ln022.next = ln023

    var result = solutions.addTwoNumbers(ln011, ln021)
    while (result != null) {
        println(result.valueSample)
        result = result.next
    }
//    do {
//        println(result?.valueSample)
//        result = result?.next
//    } while (result?.next != null)
}

fun program008() {
    val unsorted = intArrayOf(3, 1, 2, 4)

    val sortedByRemainder = unsorted.sortedBy { it % 3 }
    // the sorting is stable: the order of 1 (1 % 3 == 1) and 4 (4 % 3 == 1) was preserved
    println(sortedByRemainder) // [3, 1, 4, 2]

    val mapping = mapOf(1 to "one", 2 to "two", 3 to "three", 4 to "four")
    val sortedByPronunciation = unsorted.sortedBy {
        // take a key to sort by from the mapping
        mapping.getOrDefault(it, "unknown")
    }
    // four < one < three < two, lexicographically
    println(sortedByPronunciation) // [4, 1, 3, 2]

    // the original array remains unchanged
    println(unsorted.toList()) // [3, 1, 2, 4]
}

fun program007() {
    val map = mapOf(Pair("abc", 1), Pair("c", 3), Pair("bd", 4), Pair("bc", 2))
    val sorted = map.toSortedMap(compareBy<String> {it.length}.thenBy { it })
    println(sorted.keys)
}
fun program006() {
    val map = mapOf(Pair("c",3), Pair("b", 2), Pair("d", 1))
    val sorted = map.toSortedMap()

    println(sorted.keys)
    println(sorted.values)
}

fun program005() {
    val solutions = Solutions()
    //val nums = intArrayOf(2, 7, 11, 15)
    val nums = intArrayOf(3, 2, 3,3,6)
    nums.forEach { item -> print("$item,") }
    val answer = solutions.majorityElement(nums)
    println()
    println(answer)
}

fun program004() {
    val list = Node(1, Node(2, Node(4, Node(5))))
    println(list)
}

fun program003() {

    val tree = makeBeverageTree()
    tree.forEachDepthFirst {
        println(it.value)
    }
    println("====")
    tree.forEachLevelOrder {
        println(it.value)
    }
    tree.search("Chai")
}

fun makeBeverageTree(): TreeNodeV0<String> {
    val tree = TreeNodeV0("Beverages")
    val hot = TreeNodeV0("Hot")
    val cold = TreeNodeV0("Cold")

    val tea = TreeNodeV0("Tea")
    val coffee = TreeNodeV0("Coffee")
    val chocolate = TreeNodeV0("Chocolate")

    val blackTea = TreeNodeV0("Black Tea")
    val greenTea = TreeNodeV0("Green Tea")
    val chainTea = TreeNodeV0("Chai")

    val soda = TreeNodeV0("Soda")
    val milk = TreeNodeV0("Milk")

    val gingerAle = TreeNodeV0("Ginger Ale")
    val bitterLemon = TreeNodeV0("Bitter Lemon")

    tree.add(hot)
    tree.add(cold)

    hot.add(tea)
    hot.add(coffee)
    hot.add(chocolate)

    cold.add(soda)
    cold.add(milk)

    tea.add(blackTea)
    tea.add(greenTea)
    tea.add(chainTea)

    soda.add(gingerAle)
    soda.add(bitterLemon)

    return tree
}

fun program002() {
    println("((())))".isValidParentheses())
    println("(((())))".isValidParentheses())
}

fun program001() {
    val solutions = Solutions()
    println("Test 01 Integer is Polidrome")
    val result = solutions.isPalindrome(12233221)
    println(result)
    println()

    println("Test 02 The First uniq number ")
    val str01 = "hhello";
    val resultStr01 = solutions.firstUniqChar(str01)
    println(resultStr01)

    val resultStr02 = solutions.getMapEachCaracter(str01)
    println(resultStr02)

    println("Test 03 The First uniq number ")
    val resultStr03 = solutions.firstUniqCharV2(str01)
    println(resultStr03)

    println("Test 04 Two Sum")
    val nums = intArrayOf(2, 7, 11, 15)
    val target = 9
    val result05 = solutions.twoSum(nums, target)
    println(result05)
    result05.forEach { item -> print("$item ") }

    println("Test 05 Two Sum")
    val nums2 = intArrayOf(3, 2, 4)
    val target2 = 6
    val result06 = solutions.twoSum(nums2, target2)
    println(result06)
    result06.forEach { item -> print("$item ") }
}