package org.example.algoriyhms

import javax.swing.tree.TreeNode


fun main() {
    program27001()
    program27002()

}

fun program27001() {
    println("==> program27001")
    println()
    val item001 = TreeNodeSampleV14(1)
    val item002 = TreeNodeSampleV14(2)
    val item003 = TreeNodeSampleV14(3)
    item001.right = item002
    item002.left = item003

    var result = inorderTraversal(item001)
    println("result = $result")
    println()

}

fun program27002() {

    println("==> program27002")
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

    var result = inorderTraversal(item001)
    println("result = $result")
    println()

}

private val res: MutableList<Int> = ArrayList()
fun inorderTraversal(root: TreeNodeSampleV14?): List<Int>? {
    traverse(root)
    return res
}

private fun traverse(root: TreeNodeSampleV14?) {
    if (root == null) {
        return
    }
    traverse(root.left)
    res.add(root.sampleValue)
    traverse(root.right)
}


//Binary Tree Inorder Traversal
//Обход двоичного дерева в обратном порядке
//
//Example 1:
//
//Input: root = [1,null,2,3]
//
//Output: [1,3,2]
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
//Output: [4,2,6,5,7,1,3,9,8]
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


///Example 3:
//
//Input: root = []
//
//Output: []
//
//Example 4:
//
//Input: root = [1]
//
//Output: [1]
//
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 100].
//-100 <= Node.val <= 100
//
//
//Follow up: Recursive solution is trivial, could you do it iteratively?