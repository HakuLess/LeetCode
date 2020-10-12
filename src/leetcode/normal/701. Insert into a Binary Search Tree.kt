package leetcode.normal

import leetcode.contest.utils.TreeNode

class Solution701 {
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) {
            return TreeNode(`val`)
        }
        if (root.`val` < `val`) {
            val right = root.right
            if (right == null) {
                root.right = TreeNode(`val`)
            } else {
                insertIntoBST(root.right, `val`)
            }
        } else {
            val left = root.left
            if (left == null) {
                root.left = TreeNode(`val`)
            } else {
                insertIntoBST(root.left, `val`)
            }
        }
        return root
    }
}