package org.example.algoriyhms

import javax.swing.tree.TreeNode




fun main() {
    program300001()
    program300002()
    program300003()
}

fun program300001() {
    println("==> program300001")
    println()

    val item001 = TreeNodeSampleV14(1)
    val item002 = TreeNodeSampleV14(2)
    val item003 = TreeNodeSampleV14(3)

    val item004 = TreeNodeSampleV14(1)
    val item005 = TreeNodeSampleV14(2)
    val item006 = TreeNodeSampleV14(3)

    item001.left = item002
    item001.right = item003
    item004.left = item005
    item004.right = item006

    val result = isSameTreeV2(item001, item004)
    println()
    println("result = $result")
    println()

}

fun program300002() {
    println("==> program300001")
    println()
    val item001 = TreeNodeSampleV14(1)
    val item002 = TreeNodeSampleV14(2)

    val item003 = TreeNodeSampleV14(1)
    val item004 = TreeNodeSampleV14(2)

    item001.left = item002
    item003.right = item004

    val result = isSameTree(item001, item003)
    println()
    println("result = $result")
    println()

}

fun program300003() {
    println("==> program300001")
    println()
    val item001 = TreeNodeSampleV14(1)
    val item002 = TreeNodeSampleV14(2)
    val item003 = TreeNodeSampleV14(1)

    val item004 = TreeNodeSampleV14(1)
    val item005 = TreeNodeSampleV14(1)
    val item006 = TreeNodeSampleV14(2)

    item001.left = item002
    item001.right = item003
    item004.left = item005
    item004.right = item006

    val result = isSameTree(item001, item004)
    println()
    println("result = $result")
    println()

}


//SameTree
//Given the roots of two binary trees p and q, write a function to check if they are the same or not.
//
//Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
//
//Example 1:
//Input: p = [1,2,3], q = [1,2,3]
//Output: true
//
//            1                    1
//         /     \              /     \
//       2         3          2         3
//
//Example 2:
//Input: p = [1,2], q = [1,null,2]
//Output: false
//
//
//         1         1
//       /            \
//     2                2
//
//Example 3:
//Input: p = [1,2,1], q = [1,1,2]
//Output: false
//
//               1                  1
//            /     \            /     \
//          2         1        1         2
//
//Constraints:
//
//The number of nodes in both trees is in the range [0, 100].
//-104 <= Node.val <= 104


fun isSameTree(p: TreeNodeSampleV14?, q: TreeNodeSampleV14?): Boolean {
    // Base cases:
    // 1. Both are null (empty trees) - they are the same.
    if (p == null && q == null) {
        return true
    }

    // 2. One is null and the other isn't - they are different.
    if (p == null || q == null) {
        return false
    }

    // 3. Values are different - they are different.
    return if (p.sampleValue!== q.sampleValue) {
        false
    } else isSameTree(p.left, q.left) && isSameTree(p.right, q.right)

    // Recursive step:
    // If the current nodes are the same, recursively check if their left and right subtrees are the same.
}

fun isSameTreeV2(p: TreeNodeSampleV14?, q: TreeNodeSampleV14?): Boolean {
    if (p == null && q == null) return true
    if (p != null && q == null) return false
    if (p == null && q != null) return false
    if (p?.sampleValue !== q?.sampleValue) return false
    if (isSameTreeV2(p?.left, q?.left) === false) return false
    return if (isSameTreeV2(p?.right, q?.right) === false) false else true
}