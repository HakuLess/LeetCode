package leetcode.normal

import leetcode.contest.utils.TreeNode

class Solution129 {
    var ans = 0

    fun sumNumbers(root: TreeNode?): Int {
        sumTree(root, 0)
        return ans
    }

    private fun sumTree(root: TreeNode?, sum: Int) {
        if (root == null) {
            return
        }
        val cur = sum * 10 + root.`val`
        if (root.left == null && root.right == null) {
            ans += cur
        } else {
            sumTree(root.left, cur)
            sumTree(root.right, cur)
        }
    }
}