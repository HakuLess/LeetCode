package leetcode.normal

import leetcode.contest.utils.TreeNode

class Solution106 {
    private val inOrderMap = HashMap<Int, Int>()
    private var postOrderIndex = 0
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        postOrderIndex = postorder.lastIndex
        for (i in inorder.indices) {
            inOrderMap[inorder[i]] = i
        }
        return helper(postorder, 0, postorder.size)
    }

    private fun helper(postorder: IntArray, left: Int, right: Int): TreeNode? {
        if (left == right) {
            return null
        }
        val value = postorder[postOrderIndex--]
        val index = inOrderMap[value]
        val tree = TreeNode(value)
        tree.right = helper(postorder, index!! + 1, right)
        tree.left = helper(postorder, left, index)
        return tree
    }
}