package leetcode

class Solution988 {

    private var ans = "zzzzzzzzz"

    fun smallestFromLeaf(root: TreeNode?): String {
        if (root == null) {
            return ""
        }

        dfs(root, ('a' + root.`val`).toString())
        return ans
    }

    private fun dfs(root: TreeNode?, str: String) {
        if (root == null) {
            return
        }

        if (root.left == null && root.right == null) {
            // leaf
            ans = minOf(ans, str)
        } else {
            if (root.left != null) {
                dfs(root.left, ('a' + root.left!!.`val`) + str)
            }
            if (root.right != null) {
                dfs(root.right, ('a' + root.right!!.`val`) + str)
            }
        }
    }
}