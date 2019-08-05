package leetcode.contest.last.b04

import leetcode.TreeNode

class Solution1120 {
    var max = 0.0

    fun maximumAverageSubtree(root: TreeNode?): Double {
        return max
    }

    private fun dfs(root: TreeNode?): Pair<Int, Int> {
        if (root == null) {
            return Pair(0, 0)
        }
        val left = dfs(root.left)
        val right = dfs(root.right)

        val count = left.second + right.second + 1
        val sum = left.first + right.first + root.`val`
        max = maxOf(sum.toDouble() / count.toDouble(), max)
        return Pair(sum, count)
    }
}