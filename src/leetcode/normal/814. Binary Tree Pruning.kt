package leetcode.normal

import leetcode.TreeNode

class Solution814 {
    fun pruneTree(root: TreeNode?): TreeNode? {
        dfs(root)
        if (root == null) {
            return null
        } else if (root.`val` == 0 && root.left == null && root.right == null) {
            return null
        }
        return root
    }

    private fun dfs(root: TreeNode?): Int {
        return if (root == null) {
            0
        } else {
            val left = dfs(root.left)
            val right = dfs(root.right)
            if (left == 0) {
                root.left = null
            }
            if (right == 0) {
                root.right = null
            }
            root.`val` + right + left
        }
    }
}