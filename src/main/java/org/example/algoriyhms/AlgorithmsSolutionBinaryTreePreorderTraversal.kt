package org.example.algoriyhms


fun main() {

    program22001()
    program22002()

}

fun program22001() {
    println("===> program22001")
    println()
    val item001 = TreeNodeSampleV14(1)
    val item002 = TreeNodeSampleV14(2)
    val item003 = TreeNodeSampleV14(3)
    item001.right = item002
    item002.left = item003
    val result = preorderTraversal(item001)
    println()
    result?.map { item ->
        print(" $item ==> ")
    }
    println()
    println()

}


fun program22002() {
    println("===> program22002")
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

    val result = preorderTraversal(item001)
    println()
    result?.map { item ->
        print(" $item ==> ")
    }
    println()
    println()
}

//Предварительный обход двоичного дерева
//Binary Tree Preorder Traversal
//Given the root of a binary tree, return the preorder traversal of its nodes' values.
//      1
//        \
//         2
//        /
//      3
//
//Example 1:
//
//Input: root = [1,null,2,3]
//
//Output: [1,2,3]
//
//                  1
//              /      \
//            2          3
//          /   \          \
//        4       5          8
//              /   \      /
//             6     7    9
//
//Example 2:
//
//Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
//
//Output: [1,2,4,5,6,7,3,8,9]



//Example 3:
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

//------
//To perform a preorder traversal of a binary tree, we follow this order:
//1 Visit the current node
//2 Traverse the left subtree
//3 Traverse the right subtree
//
//This approach is naturally implemented using recursion

class TreeNodeSampleV14(var sampleValue: Int) {
    var left: TreeNodeSampleV14? = null
    var right: TreeNodeSampleV14? = null
}

fun preorderTraversal(root: TreeNodeSampleV14?): List<Int>? {
    val list: MutableList<Int> = ArrayList()
    preorder(root, list)
    return list
}

fun preorder(node: TreeNodeSampleV14?, list: MutableList<Int>) {
    if (node == null) return
    list.add(node.sampleValue) // Visit current node
    preorder(node.left, list) // Traverse left subtree
    preorder(node.right, list) // Traverse right subtree
}