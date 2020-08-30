package leetcode.contest.last.c135

import leetcode.contest.utils.TreeNode

class Solution5050 {
    fun bstToGst(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        var count = 0
        fun dfs(node: TreeNode?) {
            if (node == null) {
                return
            }
            dfs(node.right)
            count += node.`val`
            node.`val` = count
            dfs(node.left)
        }
        dfs(root)
        return root
    }
}