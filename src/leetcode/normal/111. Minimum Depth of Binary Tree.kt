package leetcode.normal

import leetcode.contest.utils.TreeNode

class Solution111 {
    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0
        val left = minDepth(root.left)
        val right = minDepth(root.right)
        return if (left == 0 || right == 0) {
            maxOf(left, right) + 1
        } else minOf(left, right) + 1
    }
}