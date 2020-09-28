package leetcode.normal

import leetcode.contest.utils.TreeNode

class Solution106 {

    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        val inOrderMap = HashMap<Int, Int>()
        var postOrderIndex = 0
        postOrderIndex = postorder.lastIndex
        for (i in inorder.indices) {
            inOrderMap[inorder[i]] = i
        }
        fun dfs(postorder: IntArray, left: Int, right: Int): TreeNode? {
            if (left == right) {
                return null
            }
            val value = postorder[postOrderIndex--]
            val index = inOrderMap[value]
            val tree = TreeNode(value)
            tree.right = dfs(postorder, index!! + 1, right)
            tree.left = dfs(postorder, left, index)
            return tree
        }
        return dfs(postorder, 0, postorder.size)
    }
}