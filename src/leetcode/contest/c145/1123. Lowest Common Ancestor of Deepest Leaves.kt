package leetcode.contest.c145

import leetcode.TreeNode

class Solution {
    var ans: TreeNode? = null
    var cur = -1
    fun lcaDeepestLeaves(root: TreeNode?): TreeNode? {
        dfs(root, 0)
        return ans
    }

    private fun dfs(root: TreeNode?, level: Int): Int {
        if (root == null) {
            return level
        }
        val left = dfs(root.left, level + 1)
        val right = dfs(root.right, level + 1)
        println("${root.`val`}: $left $right")
        if (right == left) {
            if (right >= cur) {
                cur = right
                ans = root
            }
        }
        return maxOf(left, right)
    }
}