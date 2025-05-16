package org.example.algoriyhms

import javax.swing.Spring.height
import javax.swing.tree.TreeNode


fun main() {
    program200001()
    program200002()
}

fun program200001() {
    println("==> program200001() ")
    println()
    val item001 = TreeNodeSampleV11(3)
    val item002 = TreeNodeSampleV11(9)
    val item003 = TreeNodeSampleV11(20)
    val item004 = TreeNodeSampleV11(15)
    val item005 = TreeNodeSampleV11(7)

    item001.left = item002
    item001.right = item003
    item003.left = item004
    item003.right = item005

    val result = isBalanced(item001)
    println("result = $result")
    println()

}


fun program200002() {
    println("==> program200002() ")
    println()
    val item001 = TreeNodeSampleV11(1)
    val item002 = TreeNodeSampleV11(2)
    val item003 = TreeNodeSampleV11(2)
    val item004 = TreeNodeSampleV11(3)
    val item005 = TreeNodeSampleV11(3)
    val item006 = TreeNodeSampleV11(4)
    val item007 = TreeNodeSampleV11(4)

    item001.left = item002
    item001.right = item003
    item002.left = item004
    item002.right = item005
    item004.left = item006
    item004.right = item007

    val result = isBalanced(item001)
    println("result = $result")
    println()
}

//Given a binary tree, determine if it is height-balanced.
//Example 1:
//Input: root = [3,9,20,null,null,15,7]
//Output: true
//              3
//           /     \
//          9       20
//                /    \
//               15     7
//

//Example 2:
//Input: root = [1,2,2,3,3,null,null,4,4]
//Output: false
//                                      1
//                                   /     \
//                                  2       2
//                                /   \
//                               3     3
//                              / \
//                             4   4
//

class TreeNodeSampleV11(val sampleVa: Int) {
    var left: TreeNodeSampleV11? = null
    var right: TreeNodeSampleV11? = null
}

fun height(root: TreeNodeSampleV11?): Int {
    if (root == null) return 0
    val leftht = height(root.left)
    val rightht = height(root.right)
    if (leftht == -1 || rightht == -1) return -1
    return if (Math.abs(leftht - rightht) > 1) -1
    else Math.max(leftht, rightht) + 1
}

fun isBalanced(root: TreeNodeSampleV11?): Boolean {
    return height(root) != -1
}


var resultBalanced = true
fun isBalancedV2(root: TreeNodeSampleV11?): Boolean {
    maxDepthV2(root)
    return resultBalanced
}
fun maxDepthV2(root: TreeNodeSampleV11?): Int {
    if (root == null) return 0
    val l = maxDepthV2(root.left)
    val r = maxDepthV2(root.right)
    if (Math.abs(l - r) > 1) resultBalanced = false
    return 1 + Math.max(l, r)
}

fun isBalancedV3(root: TreeNodeSampleV11?): Boolean {
    if (root == null) return true
    return if (Math.abs(heightV3(root.left) - heightV3(root.right)) <= 1) isBalancedV3(root.left) && isBalancedV3(root.right)
    else false
}

fun heightV3(root: TreeNodeSampleV11?): Int {
    if (root == null) return 0
    val left: Int = heightV3(root.left)
    val right: Int = heightV3(root.right)
    return Math.max(left, right) + 1
}