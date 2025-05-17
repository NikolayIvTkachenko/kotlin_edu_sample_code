package org.example.algoriyhms

fun main() {
    program29001()
    program29002()
}

fun program29001() {
    println("==> program29001")
    println()
    val item001 = TreeNodeSampleV14(1)
    val item002 = TreeNodeSampleV14(2)
    val item003 = TreeNodeSampleV14(2)
    val item004 = TreeNodeSampleV14(3)
    val item005 = TreeNodeSampleV14(4)
    val item006 = TreeNodeSampleV14(4)
    val item007 = TreeNodeSampleV14(3)

    item001.left = item002
    item001.right = item003
    item002.left = item004
    item002.right = item005
    item003.left = item006
    item003.right = item007
    println()
    //val result = isSymmetric(item001)
    //println("item001 = $item001")
    val result = isSymmetricV2(item001)
    println("result = $result")
    println()
}

fun program29002() {
    println("==> program29002")
    println()
    val item001 = TreeNodeSampleV14(1)
    val item002 = TreeNodeSampleV14(2)
    val item003 = TreeNodeSampleV14(2)
    val item004 = TreeNodeSampleV14(3)
    val item005 = TreeNodeSampleV14(3)

    item001.left = item002
    item001.right = item003
    item002.right = item004
    item002.right = item004
    item003.right = item005
    println()
    //val result = isSymmetric(item001)
    val result = isSymmetricV2(item001)
    println("result = $result")
    println()

}


//Stmmetric Tree
//Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
//
//Input: root = [1,2,2,3,4,4,3]
//Output: true
//Example 1:
//                      1                                       item001
//                  /      \                                 /           \
//                 2        2                         item002            item003
//               /   \    /   \                       /    \             /     \
//              3     4  4     3               item003    item004   item006    item007
//
//
//Example 2:
//Input: root = [1,2,2,null,3,null,3]
//Output: false
//Constraints:
//
//The number of nodes in the tree is in the range [1, 1000].
//-100 <= Node.val <= 100
//
//
//Follow up: Could you solve it both recursively and iteratively?
//
//                     1
//                  /    \
//                 2      2
//                  \       \
//                   3       3
//
//


fun checkSymmetric(leftNode: TreeNodeSampleV14?, rightNode: TreeNodeSampleV14?): Boolean {
    if (leftNode == null && rightNode == null) return true
    else if (leftNode == null || rightNode == null) return false

    // first check left of N1 and right of N2
    val leftSymmetric = checkSymmetric(leftNode.left, rightNode.right)
    val rightSymmetric = checkSymmetric(leftNode.right, rightNode.left)
    return leftNode.sampleValue === rightNode.sampleValue && leftSymmetric && rightSymmetric
}

fun isSymmetric(root: TreeNodeSampleV14): Boolean {
    return checkSymmetric(root.left, root.right)
}


fun isSymmetricV2(root: TreeNodeSampleV14?): Boolean {
    return if (root == null) true else isSymmetricV2(root.left, root.right)
}

fun isSymmetricV2(rootleft: TreeNodeSampleV14?, rootright: TreeNodeSampleV14?): Boolean {
    if (rootleft == null && rootright == null) {
        return true
    } else if (rootright == null || rootleft == null) {
        return false
    }
    if (rootleft.sampleValue !== rootright.sampleValue) return false
    if (!isSymmetricV2(rootleft.left, rootright.right)) return false
    return if (!isSymmetricV2(rootleft.right, rootright.left)) false else true
}

//Intuition
//Approach
//Symmetrical: check the mirror image of tree from any node
//It means at any node
//node.left == node.right
//node.right = node.left
//Solution:
//
//we use DFS and create an function
//boolean checkSymmetric(TreeNode leftNode,TreeNode rightNode)
//that take an leftNode and rightNode
//inside that function same as DFS
//1) checkSummetric(leftNode.left , rightNode.right)
//2) checkSummetric(leftNode.right , rightNode.left)
//So at the Left and Right Node = 3
//leftSymmetrtic = True
//rightSymmetric = True
//return (leftNode.val == rightNode.val && leftSymmetric && rightSymmetric); // True
//
//Complexity
//Time complexity:
//Space complexity:


