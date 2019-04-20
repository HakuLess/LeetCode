package leetcode.normal

import leetcode.TreeNode


class Solution783 {

    val ans = arrayListOf<Int>()
    fun minDiffInBST(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        dfs(root)
        var min = Int.MAX_VALUE
        for (i in 1 until ans.size) {
            min = minOf(ans[i] - ans[i - 1], min)
        }
        return min
    }

    private fun dfs(root: TreeNode?) {
        if (root == null) {
            return
        }
        dfs(root.left)
        ans.add(root.`val`)
        dfs(root.right)
    }
}