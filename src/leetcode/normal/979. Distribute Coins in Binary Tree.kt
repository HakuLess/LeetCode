package leetcode.normal

import leetcode.contest.utils.TreeNode
import kotlin.math.abs

class Solution979 {

    fun distributeCoins(root: TreeNode?): Int {
        var ans = 0
        fun dfs(root: TreeNode?): Int {
            if (root == null) {
                return 0
            }
            val left = dfs(root.left)
            val right = dfs(root.right)
            ans += abs(left) + abs(right)
            return root.`val` + left + right - 1
        }
        dfs(root)
        return ans
    }
}