package leetcode.normal

import leetcode.contest.utils.TreeNode

class Solution257 {
    fun binaryTreePaths(root: TreeNode?): List<String> {
        val ans = arrayListOf<String>()
        if (root == null) return ans
        fun dfs(root: TreeNode, cur: ArrayList<Int>) {
            cur.add(root.`val`)
            if (root.left == null && root.right == null) {
                ans.add(cur.joinToString("->"))
            } else {
                root.left?.let { dfs(it, ArrayList(cur)) }
                root.right?.let { dfs(it, ArrayList(cur)) }
            }
        }
        dfs(root, arrayListOf())
        return ans
    }
}