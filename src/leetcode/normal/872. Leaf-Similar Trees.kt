package leetcode.normal

import leetcode.contest.utils.TreeNode

class Solution872 {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        fun inOrder(root: TreeNode?, leaf: ArrayList<Int>) {
            if (root == null) {
                return
            }
            inOrder(root.left, leaf)
            if (root.left == null && root.right == null) {
                leaf.add(root.`val`)
            }
            inOrder(root.right, leaf)
        }
        val leaf1 = arrayListOf<Int>()
        val leaf2 = arrayListOf<Int>()
        inOrder(root1, leaf1)
        inOrder(root2, leaf2)
        return leaf1 == leaf2
    }
}