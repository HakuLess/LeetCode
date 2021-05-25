package leetcode.contest.last.c172

import leetcode.contest.utils.TreeNode

class Solution5317 {
    fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
        fun dfs(root: TreeNode?, target: Int): Boolean {
            if (root == null) {
                return true
            }
            val left = dfs(root.left, target)
            if (left) {
                root.left = null
            }
            val right = dfs(root.right, target)
            if (right) {
                root.right = null
            }
            if (left && right && target == root.`val`) {
                return true
            }
            return false
        }
        dfs(root, target)
        if (root == null) {
            return null
        }
        if (root.left == null && root.right == null && root.`val` == target) {
            return null
        }
        return root
    }
}