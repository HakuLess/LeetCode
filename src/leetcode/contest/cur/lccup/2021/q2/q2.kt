package leetcode.contest.cur.lccup.`2021`.q2

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
class Solutionq2 {

    fun maxValue(root: TreeNode?, k: Int): Int {
        fun dfs(root: TreeNode?, k: Int): IntArray {
            val dp = IntArray(k + 1)
            if (root == null) return dp
            val l = dfs(root.left, k)
            val r = dfs(root.right, k)
            var ml = Int.MIN_VALUE
            var mr = Int.MIN_VALUE
            for (i in 0..k) {
                ml = maxOf(ml, l[i])
                mr = maxOf(mr, r[i])
            }
            dp[0] = ml + mr
            for (i in 1..k) {
                for (j in 0 until i) {
                    dp[i] = maxOf(dp[i], root.`val` + l[j] + r[i - 1 - j])
                }
            }
            return dp
        }

        return dfs(root, k).max()!!
    }
}