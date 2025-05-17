package org.example.algoriyhms

fun main() {
    program23001()
    program23002()
}

fun program23001() {
    println("==> program23001")
    println()
    val item001 = TreeNodeSampleV14(1)
    val item002 = TreeNodeSampleV14(2)
    val item003 = TreeNodeSampleV14(3)
    item001.right = item002
    item002.left = item003

    var result = postorderTraversal(item001)
    println("result = $result")
    println()

}

fun program23002() {
    println("==> program23002")
    println()
    val item001 = TreeNodeSampleV14(1)
    val item002 = TreeNodeSampleV14(2)
    val item003 = TreeNodeSampleV14(3)
    val item004 = TreeNodeSampleV14(4)
    val item005 = TreeNodeSampleV14(5)
    val item006 = TreeNodeSampleV14(6)
    val item007 = TreeNodeSampleV14(7)
    val item008 = TreeNodeSampleV14(8)
    val item009 = TreeNodeSampleV14(9)

    item001.left = item002
    item001.right = item003
    item002.left = item004
    item002.right = item005
    item005.left = item006
    item005.right = item007
    item003.right = item008
    item008.left = item009

    var result = postorderTraversal(item001)
    println("result = $result")
    println()

}

//Binary Tree Postorder Traversal
//Given the root of a binary tree, return the postorder traversal of its nodes' values.
//Example 1:
//
//Input: root = [1,null,2,3]
//
//Output: [3,2,1]
//
//Explanation:
//      1
//        \
//         2
//        /
//      3



//Example 2:
//
//Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
//
//Output: [4,6,7,5,2,9,8,3,1]
//
//Explanation:
//
//                  1
//              /      \
//            2          3
//          /   \          \
//        4       5          8
//              /   \      /
//             6     7    9
//

//Constraints:
//
//The number of the nodes in the tree is in the range [0, 100].
//-100 <= Node.val <= 100
//
//
//Follow up: Recursive solution is trivial, could you do it iteratively?

fun postorderTraversal(root: TreeNodeSampleV14?): List<Int>? {
    val li: MutableList<Int> = ArrayList()
    post(root, li)
    return li
}

fun post(root: TreeNodeSampleV14?, li: MutableList<Int>) {
    if (root == null) return
    post(root.left, li)
    post(root.right, li)
    li.add(root.sampleValue)
}