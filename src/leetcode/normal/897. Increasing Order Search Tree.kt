package leetcode.normal

import leetcode.contest.utils.TreeNode

class Solution897 {
    fun increasingBST(root: TreeNode?): TreeNode? {
        val ans = TreeNode(0)
        var cur = ans
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
        inorder(root)
        return ans.right
    }


}