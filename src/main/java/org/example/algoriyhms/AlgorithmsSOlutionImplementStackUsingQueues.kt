package org.example.algoriyhms

import java.util.*


fun main() {

    program54001()

}

fun program54001() {
    println("==> program54001")
    println()
    //Input
    //["MyStack", "push", "push", "top", "pop", "empty"]
    //[[], [1], [2], [], [], []]
    //Output
    //[null, null, null, 2, 2, false]


}

//Approach
//PUSH opeartion:
//
//We have taken 2 queues.
//we are checking until and unless the queue1 is not empty, remove the elemnt from the front of the queue1 and add it into queue2.
//then add the new element into the queue1.(AACHA,YOU CAN THINK THE QUEUE 1 AS A STACK, MEANS THE FINAL ANSWER WE WILL GET FROM IT, AND QUEUE2 IS JUST A HELPING QUEUE TO STORE THE ELEMENTS AT SOME POINT OF TIME.** BECHARA QUEUE2.** )
//Then again we will run a loop util and unless the queue2 is empty,and add the elements in queue1 by removing it from queue2.
//HMM!! WE HAVE UNDERSTOOD THE PROBLEM
//You people are smart enough to understand the peek(),top(), and empty() methods, so not explaining those(By looking at the code we can understand ,just using built in functions).
//Complexity
//Time complexity:
//
//according to leetcode time complexcity is O(N).


//Implement Stack using Queues
//
//Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
//
//Implement the MyStack class:
//
//void push(int x) Pushes element x to the top of the stack.
//int pop() Removes the element on the top of the stack and returns it.
//int top() Returns the element on the top of the stack.
//boolean empty() Returns true if the stack is empty, false otherwise.
//Notes:
//
//You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
//Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
//
//
//Example 1:
//
//Input
//["MyStack", "push", "push", "top", "pop", "empty"]
//[[], [1], [2], [], [], []]
//Output
//[null, null, null, 2, 2, false]
//
//Explanation
//MyStack myStack = new MyStack();
//myStack.push(1);
//myStack.push(2);
//myStack.top(); // return 2
//myStack.pop(); // return 2
//myStack.empty(); // return False
//
//
//Constraints:
//
//1 <= x <= 9
//At most 100 calls will be made to push, pop, top, and empty.
//All the calls to pop and top are valid.


internal class MyStack {
    var q1: LinkedList<Any> = LinkedList<Any>()
    var q2: LinkedList<Any> = LinkedList<Any>()
    fun push(x: Int) {
        while (!q1.isEmpty()) {
            q2.add(q1.remove())
        }
        q1.add(x) //pushing the current element into the stack
        while (!q2.isEmpty()) {
            q1.add(q2.remove())
        }
    }

    fun pop(): Any? {
        return q1.remove()
    }

    fun top(): Any? {
        return q1.peek()
    }

    fun empty(): Boolean {
        return if (q1.isEmpty()) true else false
    }
}


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//Approach
//Explanation:
//Base Case: If the root is null (empty tree), there’s nothing to invert, so return null.
//Swap Children:
//
//TreeNode temp = root.left;
//// Store the left child in a temporary variable.
//root.left = root.right;
//// Make the right child the new left child.
//root.right = temp;
////  Make the original left child (now stored in temp) the new right child.
//Recursive Calls:
//invertTree(root.left);
//// Recursively call invertTree to invert the left subtree.
//invertTree(root.right);
//Recursively call invertTree to invert the right subtree.
//Return Root:
//After the left and right subtrees are inverted, return the modified root. The original tree is now inverted.
//
//Code