package leetcode.normal

import leetcode.TreeNode
import java.util.*

class Solution5017 {
    var ans = 0L
    val mod = 1000000007

    fun sumRootToLeaf(root: TreeNode?): Int {
        val queue: Queue<TreeNode> = LinkedList<TreeNode>()

        if (root == null) {
            return 0
        }

        dfs(root, 0)
        return (ans % mod).toInt()
    }

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
}