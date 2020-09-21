package leetcode.normal

import leetcode.contest.utils.TreeNode


class Solution538 {
    private var sum = 0
    fun convertBST(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        convertBST(root.right)
        sum += root.`val`
        root.`val` = sum
        convertBST(root.left)
        return root
    }
}