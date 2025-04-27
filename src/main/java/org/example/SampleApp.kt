package org.example

import org.example.algoriyhms.Solutions
import org.example.structures.linkedList.Node
import org.example.structures.stack.isValidParentheses
import org.example.structures.tree.TreeNodeV0

fun main() {

    //program001()
    //program002()
    //program003()
    program004()
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