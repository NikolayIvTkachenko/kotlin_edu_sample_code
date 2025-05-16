package org.example.algoriyhms

import javax.swing.tree.TreeNode




fun main() {
    program13001()
    program13002()
}

fun program13001() {
    println("===> program13001")
    println()
    val target = 22
    val itemRoot = TreeNodeV10(5)
    val item001 = TreeNodeV10(4)
    val item002 = TreeNodeV10(8)
    val item003 = TreeNodeV10(11)
    val item004 = TreeNodeV10(13)
    val item005 = TreeNodeV10(4)
    val item006 = TreeNodeV10(7)
    val item007 = TreeNodeV10(2)
    val item008 = TreeNodeV10(1)
    itemRoot.left = item001
    itemRoot.right = item002
    item001.left = item003
    item002.left = item004
    item002.right = item005
    item003.left = item006
    item003.right = item007
    item005.right = item008

    val result = hasPathSumV1(itemRoot, target)
    println("result = $result")
    println()

}

fun program13002() {
    println("===> program13002")
    println()

}

//Given the root of a binary tree and an integer targetSum, return true if the
// tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
//
//A leaf is a node with no children.

//            5
//        /       \
//       4         8
//     /   \     /   \
//    11        13    4
//   /  \              \
//  7    2              1
//

//Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//Output: true
//Explanation: The root-to-leaf path with the target sum is shown.

//           1
//         /   \
//        2     3
//
//
//


//Input: root = [1,2,3], targetSum = 5
//Output: false
//Explanation: There are two root-to-leaf paths in the tree:
//(1 --> 2): The sum is 3.
//(1 --> 3): The sum is 4.
//There is no root-to-leaf path with sum = 5.

//Constraints:
//
//The number of nodes in the tree is in the range [0, 5000].
//-1000 <= Node.val <= 1000
//-1000 <= targetSum <= 1000

class TreeNodeV10(var sampleValue: Int) {
    var left: TreeNodeV10? = null
    var right: TreeNodeV10? = null
}

fun hasPathSumV1(root: TreeNodeV10?, targetSum: Int): Boolean {
    if (root == null) return false
    if (root.left == null && root.right == null) return targetSum - root.sampleValue === 0
    val left = hasPathSumV1(root.left, targetSum - root.sampleValue)
    val right = hasPathSumV1(root.right, targetSum - root.sampleValue)
    return left || right
}