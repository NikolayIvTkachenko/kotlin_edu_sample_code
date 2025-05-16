package org.example.algoriyhms

fun main() {
    program14001()
    program14002()
    program14003()

}

fun program14001() {
    println("===> program14001")
    println()
    var item001 = ListNodeSampleV10(3)
    var item002 = ListNodeSampleV10(2)
    var item003 = ListNodeSampleV10(0)
    var item004 = ListNodeSampleV10(-4)
    item001.next = item002
    item002.next = item003
    item003.next = item004
    item004.next = item002
    val result = hasCycle(item001)
    println("Has cycle = $result")
    println()


}


fun program14002() {
    println("===> program14002")
    println()
    var item001 = ListNodeSampleV10(1)
    var item002 = ListNodeSampleV10(2)
    item001.next = item002
    item002.next = item001

    val result = hasCycle(item001)
    println("Has cycle = $result")
    println()
}


fun program14003() {
    println("===> program14003")
    println()
    var item001 = ListNodeSampleV10(1)
    val result = hasCycle(item001)
    println("Has cycle = $result")
    println()
}

//Given head, the head of a linked list, determine if the linked list has a cycle in it.
//
//There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
//
//Return true if there is a cycle in the linked list. Otherwise, return false.

//Example 1:
//Input: head = [3,2,0,-4], pos = 1
//Output: true
//Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
//  [3] -> [2] -> [0] -> [-4]
//          | ___________ |
//


//Example 2:
//Input: head = [1,2], pos = 0
//Output: true
//Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
//  [1] -> [2]
//   | ____ |

//Example 3:
//Input: head = [1], pos = -1
//Output: false
//Explanation: There is no cycle in the linked list.
//[1]

class ListNodeSampleV10(var campleValue: Int) {
    var next: ListNodeSampleV10? = null
}

fun hasCycle(head: ListNodeSampleV10?): Boolean {
    if (head?.next == null) {
        return false
    }
    var slow = head
    var fast = head
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
        if (slow == fast) {
            return true
        }
    }
    return false
}
//Approach
//Imagine that you have a chain (a linked list). We need to find out if it forms a ring.
//
//Two "runners": We send two "runners" along the chain - slow and fast.
//Slow: Walks along one link of the chain.
//Fast: Steps through two links at once.
//What can happen:
//There is no ring: A fast "runner" reaches the end of the chain (breakage). So there is no ring.
//There is a ring: A fast runner, running in a circle, will catch up with a slow one sooner or later.
// So there is a ring!
//Bottom line: If the "runners" have met, there is a ring. If the fastest one has reached the end,
// there is no ring.
//That's all! It's like two cars driving on a highway: one slower, the other faster.
// If there is a ring, then they will
// definitely meet. If not, the fast one will go far ahead and disappear from sight.