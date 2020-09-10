package leetcode.normal

import leetcode.contest.utils.TreeNode
import java.util.*

class Solution5017 {
    fun sumRootToLeaf(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        var ans = 0L
        val mod = 1000000007
        fun dfs(node: TreeNode, cur: Long) {
            if (node.left == null && node.right == null) {
                ans += (cur * 2 + node.`val`) % mod
                ans %= mod
            }
            if (node.left != null) {
                dfs(node.left!!, (cur * 2 + node.`val`) % mod)
            }
            if (node.right != null) {
                dfs(node.right!!, (cur * 2 + node.`val`) % mod)
            }
        }
        dfs(root, 0)
        return (ans % mod).toInt()
    }
}