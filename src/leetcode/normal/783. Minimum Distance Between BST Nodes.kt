package leetcode.normal

import leetcode.contest.utils.TreeNode


class Solution783 {
    fun minDiffInBST(root: TreeNode?): Int {
        val ans = arrayListOf<Int>()
        if (root == null) {
            return 0
        }
        fun dfs(root: TreeNode?) {
            if (root == null) {
                return
            }
            dfs(root.left)
            ans.add(root.`val`)
            dfs(root.right)
        }
        dfs(root)
        var min = Int.MAX_VALUE
        for (i in 1 until ans.size) {
            min = minOf(ans[i] - ans[i - 1], min)
        }
        return min
    }
}