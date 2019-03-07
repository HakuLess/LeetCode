package leetcode

import java.util.*

class Solution114 {

    fun flatten(root: TreeNode?): Unit {
        if (root == null) {
            return
        }

        val stack = Stack<TreeNode?>()
        stack.push(root)
        var pre: TreeNode? = null
        while (stack.isNotEmpty()) {
            val item = stack.pop() ?: continue
            if (pre != null) {
                pre.right = item
            }
            stack.push(item.right)
            stack.push(item.left)

            item.left = null
            item.right = null
            pre = item
        }

    }
}