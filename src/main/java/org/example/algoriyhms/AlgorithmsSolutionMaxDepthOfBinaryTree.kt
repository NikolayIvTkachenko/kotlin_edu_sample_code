package org.example.algoriyhms

import javax.swing.tree.TreeNode




fun main() {
    program28001()
    program28002()

}

fun program28001() {

    println("==> program25001")
    println()
    val item001 = TreeNodeSampleV14(3)
    val item002 = TreeNodeSampleV14(9)
    val item003 = TreeNodeSampleV14(20)
    val item004 = TreeNodeSampleV14(15)
    val item005 = TreeNodeSampleV14(7)
    item001.left = item002
    item001.right = item003
    item003.left = item004
    item003.right = item005
    println()
    val result = maxDepth(item001)
    println("result = $result")
    println()

}


fun program28002() {



}


fun maxDepth(root: TreeNodeSampleV14?): Int {
    if (root == null) return 0
    val left = maxDepth(root.left)
    val right = maxDepth(root.right)
    return 1 + Math.max(right, left)
}

//Given the root of a binary tree, return its maximum depth.
//
//A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//
//
//
//Example 1:
//
//                 3
//              /     \
//             9       20
//                   /    \
//                  15     7
//
//
//Input: root = [3,9,20,null,null,15,7]
//Output: 3
//Example 2:
//
//Input: root = [1,null,2]
//Output: 2
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 104].
//-100 <= Node.val <= 100