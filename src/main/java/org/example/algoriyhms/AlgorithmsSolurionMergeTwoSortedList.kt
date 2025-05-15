package org.example.algoriyhms

fun main() {
    program100001()
    program100002()
}

fun program100001() {
    println("==> program100001")
    println()
    //[1,2,4], list2 = [1,3,4]
    //ListNode
    val l1001 = ListNode(1)
    val l1002 = ListNode(2)
    val l1003 = ListNode(4)
    l1001.next = l1002
    l1002.next = l1003

    val l2001 = ListNode(1)
    val l2002 = ListNode(3)
    val l2003 = ListNode(4)
    l2001.next = l2002
    l2002.next = l2003

    val result = mergeTwoSortedList(l1001, l2001)
    var rCycler = result
    while (rCycler != null) {
        print(" ${rCycler.valueSample} => ")
        rCycler = rCycler.next
    }

}

fun program100002() {
    println("==> program100002")
    println()
    //list1 = [], list2 = [0]

    //mergeTwoSortedList
}
//You are given the heads of two sorted linked lists list1 and list2.
//
//Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
//
//Return the head of the merged linked list.

//1 -> 2 -> 4
//1 -> 3 -> 4

//1 -> 1 -> 2 -> 3 -> 4 -> 4
//Input: list1 = [1,2,4], list2 = [1,3,4]
//Output: [1,1,2,3,4,4]
//Example 2:
//
//Input: list1 = [], list2 = []
//Output: []
//Example 3:
//
//Input: list1 = [], list2 = [0]
//Output: [0]
//
//
//Constraints:
//
//The number of nodes in both lists is in the range [0, 50].
//-100 <= Node.val <= 100
//Both list1 and list2 are sorted in non-decreasing order.
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

fun mergeTwoSortedList(l1: ListNode?, l2: ListNode?): ListNode? {
    var l1 = l1
    var l2 = l2
    val prehead = ListNode(-1)
    var cur: ListNode? = prehead
    while (l1 != null && l2 != null) {
        if (l1.valueSample <= l2.valueSample) {
            cur!!.next = l1
            l1 = l1.next
        } else {
            cur!!.next = l2
            l2 = l2.next
        }
        cur = cur.next
    }
    cur!!.next = l1 ?: l2
    return prehead.next

}
