package leetcode.contest.c140

import leetcode.TreeNode

class Solution5084 {
    //    fun sufficientSubset(root: TreeNode?, limit: Int): TreeNode? {
//        if (dfs(root, limit, 0) < limit) {
//            return null
//        }
//        return root
//    }
//
//    fun dfs(root: TreeNode?, limit: Int, pre: Int): Int {
//        if (root == null)
//            return pre
//        val l = dfs(root.left, limit, pre + root.`val`)
//        val r = dfs(root.right, limit, pre + root.`val`)
//        if (root.left != null && l < limit) root.left = null
//        if (root.right != null && r < limit) root.right = null
//        return maxOf(l, r)
//    }
    fun sufficientSubset(root: TreeNode?, limit: Int): TreeNode? {
        val ans = dfs(root, limit, 0)
        return if (ans) {
            root
        } else {
            null
        }
    }

    private fun dfs(root: TreeNode?, limit: Int, cur: Int): Boolean {
        if (root == null) {
            return cur < limit
        }
        val left = dfs(root.left, limit, cur + root.`val`)
        val right = dfs(root.right, limit, cur + root.`val`)
        if (root.left == null && root.right == null) {
            return cur + root.`val` < limit
        }
        if (!left) {
            root.left = null
        }
        if (!right) {
            root.right = null
        }

        return !(!left && !right && cur + root.`val` < limit)
    }
}