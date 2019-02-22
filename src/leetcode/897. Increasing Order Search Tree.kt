package leetcode

import java.util.*

class Solution897 {
    lateinit var cur: TreeNode

    fun increasingBST(root: TreeNode?): TreeNode? {
        val ans = TreeNode(0)
        cur = ans
        inorder(root)
        return ans.right
    }

    fun inorder(node: TreeNode?) {
        if (node == null) {
            return
        }
        inorder(node.left)
        node.left = null
        cur.right = node
        cur = node
        inorder(node.right)
    }
}