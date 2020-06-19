package leetcode.normal

import leetcode.contest.utils.TreeNode

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution951 {
    fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
        if (root1?.`val` != root2?.`val`) return false
        if (root1 == null && root2 == null) return true
        return (flipEquiv(root1?.left, root2?.left) && flipEquiv(root1?.right, root2?.right)) ||
                (flipEquiv(root1?.right, root2?.left) && flipEquiv(root1?.left, root2?.right))
    }
}