package leetcode.normal

import leetcode.contest.utils.TreeNode

class Solution965 {
    fun isUnivalTree(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        return dfs(root.left, root.`val`) && dfs(root.right, root.`val`)
    }

    private fun dfs(root: TreeNode?, value: Int): Boolean {
        return when {
            root == null -> {
                true
            }
            root.`val` == value -> {
                dfs(root.left, root.`val`) && dfs(root.right, root.`val`)
            }
            else -> {
                false
            }
        }
    }
}