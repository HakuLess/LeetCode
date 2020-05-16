package leetcode.contest.cur.b26

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
class Solution5398 {

    var ans = 0
    fun goodNodes(root: TreeNode?): Int {
        dfs(root, Int.MIN_VALUE / 2)
        return ans
    }

    private fun dfs(root: TreeNode?, max: Int) {
        if (root == null) {
            return
        }
        if (root.`val` >= max) {
            ans++
        }
        dfs(root.left, maxOf(root.`val`, max))
        dfs(root.right, maxOf(root.`val`, max))
    }
}