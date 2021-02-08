package leetcode.normal

import leetcode.contest.utils.TreeNode
import java.util.*

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
class Solution623 {
    fun addOneRow(root: TreeNode?, v: Int, d: Int): TreeNode? {
        if (d == 0 || d == 1) {
            val head = TreeNode(v)
            if (d == 1) head.left = root
            else head.right = root
            return head
        }
        if (root != null && d > 1) {
            root.left = addOneRow(root.left, v, if (d > 2) d - 1 else 1)
            root.right = addOneRow(root.right, v, if (d > 2) d - 1 else 0)
        }
        return root
    }
}