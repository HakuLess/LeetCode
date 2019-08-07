package leetcode.normal

import leetcode.contest.utils.TreeNode
import java.util.*

class Solution1008 {
    fun bstFromPreorder(preorder: IntArray): TreeNode? {
        if (preorder.isEmpty()) {
            return null
        }
        val root = TreeNode(preorder[0])
        val stack = Stack<TreeNode>()
        stack.push(root)
        for (i in 1 until preorder.size) {
            var peek = stack.peek()
            while (stack.isNotEmpty() && preorder[i] > stack.peek().`val`) {
                peek = stack.pop()
            }
            val item = TreeNode(preorder[i])

            if (preorder[i] < peek.`val`) {
                peek.left = item
                stack.push(item)
            } else {
                peek.right = item
                stack.push(item)
            }
        }

        return root
    }
}