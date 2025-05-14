package org.example.algoriyhms

fun main() {
    program2001()
    program2002()
    program2003()
}

fun program2001() {
    println("========> program2001 ")
//    val linkedList01 = LinkedList<Int>()
//    val linkedList02 = LinkedList<Int>()
//    linkedList01.add(2)
//    linkedList01.add(4)
//    linkedList01.add(3)
//    linkedList02.add(5)
//    linkedList02.add(6)
//    linkedList02.add(4)

    val node011 = ListNode(2)
    val node012 = ListNode(4)
    val node013 = ListNode(3)
    node011.next = node012
    node012.next = node013

    val node021 = ListNode(5)
    val node022 = ListNode(6)
    val node023 = ListNode(4)
    node021.next = node022
    node022.next = node023

    var result = addTwoNumbers(node011, node021)
    println(result)

    while (result != null) {
        println(result.valueSample)
        result = result.next
    }
}

fun program2002() {
    println("========> program2002 ")
    val node011 = ListNode(0)

    val node021 = ListNode(0)

    var result = addTwoNumbers(node011, node021)
    println(result)

    while (result != null) {
        println(result.valueSample)
        result = result.next
    }
}

fun program2003() {
    println("========> program2003 ")

    val node011 = ListNode(9)
    val node012 = ListNode(9)
    val node013 = ListNode(9)
    val node014 = ListNode(9)
    val node015 = ListNode(9)
    val node016 = ListNode(9)
    val node017 = ListNode(9)
    node011.next = node012
    node012.next = node013
    node013.next = node014
    node014.next = node015
    node016.next = node017

    val node021 = ListNode(9)
    val node022 = ListNode(9)
    val node023 = ListNode(9)
    val node024 = ListNode(9)
    node021.next = node022
    node022.next = node023
    node023.next = node024

    //var result = addTwoNumbers(node011, node021)
    var result = addTwoNumbersV2(node011, node021)
    println(result)

    while (result != null) {
        println(result.valueSample)
        result = result.next
    }
}

//Add Two Numbers
//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
//Example 2:
//
//Input: l1 = [0], l2 = [0]
//Output: [0]
//Example 3:
//
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]

//Incorrect
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var l1 = l1
    var l2 = l2
    var carry = 0
    var p: ListNode?
    val dummy = ListNode(0)
    p = dummy
    while (l1 != null || l2 != null || carry != 0) {
        if (l1 != null) {
            carry += l1.valueSample
            l1 = l1.next
        }
        if (l2 != null) {
            carry += l2.valueSample
            l2 = l2.next
        }
        p!!.next = ListNode(carry % 10)
        carry /= 10
        p = p.next
    }
    return dummy.next
}

fun addTwoNumbersV2(l1: ListNode?, l2: ListNode?): ListNode? {
    // Dummy node to start the result list
    var l1 = l1
    var l2 = l2
    val dummy = ListNode(0)
    var curr: ListNode? = dummy
    var carry = 0

    // Traverse both lists until both are null and no carry is left
    while (l1 != null || l2 != null || carry != 0) {
        val a = l1?.valueSample ?: 0
        val b = l2?.valueSample ?: 0
        val sum = a + b + carry
        carry = sum / 10 // Update carry for next addition
        curr!!.next = ListNode(sum % 10) // Create new node with current digit
        curr = curr.next
        if (l1 != null) l1 = l1.next
        if (l2 != null) l2 = l2.next
    }
    return dummy.next // Head of the result list
}