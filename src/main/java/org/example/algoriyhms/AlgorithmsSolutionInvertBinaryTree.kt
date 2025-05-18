package org.example.algoriyhms





fun main() {
    program53001()
    program53002()
}

fun program53001() {
    println("==> program53001")
    println()
    //root = [4,2,7,1,3,6,9]
    val item001 = TreeNodeSampleV16(4)
    val item002 = TreeNodeSampleV16(2)
    val item003 = TreeNodeSampleV16(7)
    val item004 = TreeNodeSampleV16(1)
    val item005 = TreeNodeSampleV16(3)
    val item006 = TreeNodeSampleV16(6)
    val item007 = TreeNodeSampleV16(9)
    item001.left = item002
    item001.right = item003
    item002.left = item004
    item002.right = item005
    item003.left = item006
    item003.right = item007

    println("item001= $item001")
    println()
    val result = invertTree(item001)
    println()
    println("after result= $result")
    println()

}

fun program53002() {
    println("==> program53002")
    println()
    //root = [2,1,3]
    val item001 = TreeNodeSampleV16(2)
    val item002 = TreeNodeSampleV16(1)
    val item003 = TreeNodeSampleV16(3)
    item001.left = item002
    item001.right = item003
    println("item001= $item001")
    println()
    val result = invertTree(item001)
    println()
    println("after result= $result")
    println()


}
//Invert Binary Tree
//Given the root of a binary tree, invert the tree, and return its root.
//
//Example 1:
//Input: root = [4,2,7,1,3,6,9]
//Output: [4,7,2,9,6,3,1]
//
//            4                     4
//         /    \                /    \
//        2      7              7      2
//       / \    / \            / \    /  \
//      1   3  6   9          9   6   3  1
//
//
//Example 2:
//Input: root = [2,1,3]
//Output: [2,3,1]
//
//       2              2
//     /   \          /   \
//    1     3        3     1
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 100].
//-100 <= Node.val <= 100

class TreeNodeSampleV16(var sampleValue: Int) {
    var left: TreeNodeSampleV16? = null
    var right: TreeNodeSampleV16? = null

    override fun toString(): String {
        return "TreeNode(" +
                "sampleValue=$sampleValue, " +
                "left=$left, " +
                "right=$right)"
    }

}

fun invertTree(root: TreeNodeSampleV16?): TreeNodeSampleV16? {
    if (root == null) {
        return null
    }

    // Swap the left and right children
    var temp: TreeNodeSampleV16? = root.left
    root.left = root.right
    root.right = temp

    // Recursively invert the left and right subtrees
    invertTree(root.left)
    invertTree(root.right)
    return root
}