package leetcode.normal

import leetcode.contest.utils.TreeNode

class Solution968 {
    fun minCameraCover(root: TreeNode?): Int {
        fun dfs(root: TreeNode?): Triple<Int, Int, Int> {
            if (root == null)
                return Triple(Int.MAX_VALUE / 2, 0, 0)
            val left = dfs(root.left)
            val right = dfs(root.right)
            val a = left.third + right.third + 1
            val b = minOf(a, minOf(left.first + right.second, left.second + right.first))
            val c = minOf(a, left.second + right.second)
            return Triple(a, b, c)
        }
        return dfs(root).second
    }
}