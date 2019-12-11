package leetcode.normal

import leetcode.contest.utils.TreeNode

class Solution101 {
    fun isSymmetric(root: TreeNode?): Boolean {
        return if (root != null) {
            isSubSymmetric(root.left, root.right)
        } else {
            true
        }
    }

    private fun isSubSymmetric(left: TreeNode?, right: TreeNode?): Boolean {
        return when {
            left?.`val` == right?.`val` && left != null -> {
                isSubSymmetric(left.left, right?.right) && isSubSymmetric(left.right, right?.left)
            }
            left == null && right == null ->
                true
            else ->
                false
        }
    }
}