package leetcode.contest.last.b17

import leetcode.contest.utils.TreeNode


class Solution5145 {
    var ans = 0
    fun sumEvenGrandparent(root: TreeNode?): Int {
        helper(root, a = false, b = false)
        return ans
    }

    private fun helper(cur: TreeNode?, a: Boolean, b: Boolean) {
        if (cur == null) {
            return
        }

        helper(cur.left, b, cur.`val` % 2 == 0)
        helper(cur.right, b, cur.`val` % 2 == 0)

        if (a) {
            ans += cur.`val`
        }
    }
}