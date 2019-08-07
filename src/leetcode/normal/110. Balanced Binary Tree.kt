package leetcode.normal

import leetcode.contest.utils.TreeNode
import kotlin.math.abs

class Solution110 {
    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }

        return if (abs(getDepth(root.left, 0) - getDepth(root.right, 0)) > 1) {
            false
        } else {
            isBalanced(root.left) && isBalanced(root.right)
        }
    }

    fun getDepth(root: TreeNode?, depth: Int): Int {
        if (root == null) {
            return depth
        }
        return maxOf(getDepth(root.left, depth + 1),
                getDepth(root.right, depth + 1))
    }
}