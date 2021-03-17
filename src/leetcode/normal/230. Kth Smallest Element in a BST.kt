package leetcode.normal

import leetcode.contest.utils.TreeNode
import leetcode.contest.utils.count
import leetcode.contest.utils.find

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
class Solution230 {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        when {
            root?.left.count() == k - 1 -> {
                return root!!.`val`
            }
            root?.left.count() > k - 1 -> {
                return kthSmallest(root!!.left, k)
            }
            else -> {
                return kthSmallest(root!!.right, k - root.left.count() - 1)
            }
        }
    }
}