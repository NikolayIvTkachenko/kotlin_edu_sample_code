package org.example.algoriyhms

fun main() {
    program25001()
    program25002()
}

fun program25001() {
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
    val result = minDepth(item001)
    println("result = $result")
    println()

}

fun program25002() {


}

//Minimum Depth of Binary Tree
//Минимальная глубина двоичного дерева
//Given a binary tree, find its minimum depth.
//
//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
//
//Note: A leaf is a node with no children.
//
//                      3
//                    /   \
//                   9     20
//                       /    \
//                      15     7
//
//Example 1:



//Input: root = [3,9,20,null,null,15,7]
//Output: 2
//Example 2:
//
//Input: root = [2,null,3,null,4,null,5,null,6]
//Output: 5
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 105].
//-1000 <= Node.val <= 1000

fun minDepth(root: TreeNodeSampleV14?): Int {
    if (root == null) return 0
    val left = minDepth(root.left)
    val right = minDepth(root.right)
    return if (left == 0 || right == 0) left + right + 1
    else Math.min(left, right) + 1
}

fun minDepthV2(root: TreeNodeSampleV14?): Int {
    if (root == null) return 0
    val L: Int = minDepth(root.left)
    val R: Int = minDepth(root.right)
    return 1 + if (Math.min(L, R) > 0) Math.min(L, R) else Math.max(L, R)
}

fun minDepthV3(root: TreeNodeSampleV14?): Int {
    if (root == null) return 0
    val L: Int = minDepth(root.left)
    val R: Int = minDepth(root.right)
    val m = Math.min(L, R)
    return 1 + if (m > 0) m else Math.max(L, R)
}

fun minDepthV4(root: TreeNodeSampleV14?): Int {
    if (root == null) return 0
    val L: Int = minDepth(root.left)
    val R: Int = minDepth(root.right)
    return if (L < R && L > 0 || R < 1) 1 + L else 1 + R
}