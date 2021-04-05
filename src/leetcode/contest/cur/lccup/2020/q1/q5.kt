package leetcode.contest.cur.`2020`.q1

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
class Solutionq5 {
    fun minimalExecTime(root: TreeNode?): Double {
        if (root == null) {
            return 0.0
        }
        val left = minimalExecTime(root.left)
        val right = minimalExecTime(root.right)

        var ans = left
        ans = maxOf(ans, right)
        ans = maxOf(ans, (getSum(root.left) + getSum(root.right)) / 2)
        return ans + root.`val`
    }

    private fun getSum(root: TreeNode?): Double {
        if (root == null) {
            return 0.0
        }
        return getSum(root.left) + getSum(root.right) + root.`val`
    }
}