package leetcode.normal

import leetcode.TreeNode
import kotlin.math.abs

class Solution563 {

    var sum = 0

    fun findTilt(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        dfs(root)
        return sum
    }

    private fun dfs(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val left = dfs(root.left)
        val right = dfs(root.right)

        sum += abs(left - right)
        return left + right + root.`val`
    }
}