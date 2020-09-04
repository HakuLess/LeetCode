package leetcode.contest.last.c145

import leetcode.contest.utils.TreeNode

class Solution1123 {
    fun lcaDeepestLeaves(root: TreeNode?): TreeNode? {
        var ans: TreeNode? = null
        var cur = -1
        fun dfs(root: TreeNode?, level: Int): Int {
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
        dfs(root, 0)
        return ans
    }
}