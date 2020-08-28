package leetcode.normal

import leetcode.contest.utils.TreeNode
import kotlin.math.abs

class Solution563 {
    fun findTilt(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        var sum = 0
        fun dfs(root: TreeNode?): Int {
            if (root == null) {
                return 0
            }
            val left = dfs(root.left)
            val right = dfs(root.right)
            sum += abs(left - right)
            return left + right + root.`val`
        }
        dfs(root)
        return sum
    }
}