package leetcode.contest.last.b17

import leetcode.contest.utils.TreeNode


class Solution5145 {
    fun sumEvenGrandparent(root: TreeNode?): Int {
        var ans = 0
        fun dfs(cur: TreeNode?, a: Boolean, b: Boolean) {
            if (cur == null) {
                return
            }
            dfs(cur.left, b, cur.`val` % 2 == 0)
            dfs(cur.right, b, cur.`val` % 2 == 0)
            if (a) {
                ans += cur.`val`
            }
        }
        dfs(root, a = false, b = false)
        return ans
    }
}