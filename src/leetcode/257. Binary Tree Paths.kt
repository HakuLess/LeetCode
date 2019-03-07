package leetcode

class Solution257 {

    val ans = arrayListOf<String>()

    fun binaryTreePaths(root: TreeNode?): List<String> {
        dfs(root, "")
        return ans
    }

    private fun dfs(root: TreeNode?, str: String) {
        if (root == null) {
            return
        }
        val cur = if (str.isNotEmpty()) {
            str + "->" + root.`val`
        } else {
            "${root.`val`}"
        }

        if (root.left == null && root.right == null) {
            ans.add(cur)
        } else {
            dfs(root.left, cur)
            dfs(root.right, cur)
        }
    }
}