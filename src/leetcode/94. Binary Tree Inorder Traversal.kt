package leetcode

import java.util.*

class Solution94 {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) {
            return arrayListOf()
        }
        val result = arrayListOf<Int>()
        val stack = Stack<TreeNode?>()
        var item = root
        while (item != null || stack.isNotEmpty()) {
            while (item != null) {
                stack.push(item)
                item = item.left
            }
            item = stack.pop()
            result.add(item!!.`val`)
            item = item.right
        }

        return result
    }
}