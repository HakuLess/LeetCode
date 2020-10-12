package leetcode.normal

import leetcode.contest.utils.TreeNode

class Solution145 {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val result = ArrayList<Int>()
        fun dfs(root: TreeNode?, result: MutableList<Int>) {
            if (root == null) {
                return
            }
            dfs(root.left, result)
            dfs(root.right, result)
            result.add(root.`val`)
        }
        dfs(root, result)
        return result
    }
}