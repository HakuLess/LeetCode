package leetcode.normal

import leetcode.contest.utils.TreeNode

class Solution104 {
    fun maxDepth(root: TreeNode?): Int {
        return if (root == null) {
            0
        } else {
            1 + maxOf(maxDepth(root.left), maxDepth(root.right))
        }
    }
}