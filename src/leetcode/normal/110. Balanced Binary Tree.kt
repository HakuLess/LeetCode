package leetcode.normal

import leetcode.contest.utils.TreeNode
import kotlin.math.abs

class Solution110 {
    fun isBalanced(root: TreeNode?): Boolean {
        fun dfs(root: TreeNode?): Int {
            if (root == null) {
                return 0
            }
            val leftHeight = dfs(root.left)
            val rightHeight = dfs(root.right)
            return if (leftHeight == -1 || rightHeight == -1 || abs(leftHeight - rightHeight) > 1) {
                -1
            } else {
                maxOf(leftHeight, rightHeight) + 1
            }
        }
        return dfs(root) >= 0
    }
}