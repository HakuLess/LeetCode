package leetcode.contest.last.c135

import leetcode.TreeNode

class Solution5050 {

    var count = 0

    fun bstToGst(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        dfs(root)
        return root
    }

    private fun dfs(node: TreeNode?) {
        if (node == null) {
            return
        }

        dfs(node.right)
        count += node.`val`
        node.`val` = count
        dfs(node.left)
    }
}