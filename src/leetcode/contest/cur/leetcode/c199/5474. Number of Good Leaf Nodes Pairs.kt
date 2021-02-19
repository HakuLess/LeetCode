package leetcode.contest.cur.leetcode.c199

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
class Solution5474 {
    fun countPairs(root: TreeNode?, distance: Int): Int {
        var ans = 0
        fun dfs(root: TreeNode?): ArrayList<Int> {
            if (root == null) return arrayListOf()
            if (root.left == null && root.right == null) return arrayListOf(0)
            val left = dfs(root.left)
            val right = dfs(root.right)
            for (i in left.indices) {
                left[i]++
            }
            for (i in right.indices) {
                right[i]++
            }
            for (i in left) {
                for (j in right) {
                    if (i + j <= distance) {
                        ans++
                    }
                }
            }
            left.addAll(right)
            return left
        }
        dfs(root)
        return ans
    }
}