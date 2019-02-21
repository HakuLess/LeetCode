package leetcode

import java.util.*

fun preorderTraversal(root: TreeNode?): List<Int> {
    if (root == null) {
        return arrayListOf()
    }

    val ans = arrayListOf<Int>()
    val stack = Stack<TreeNode?>()
    stack.push(root)

    while (stack.isNotEmpty()) {
        val item = stack.pop()
        if (item != null) {
            ans.add(item.`val`)
            stack.push(item.right)
            stack.push(item.left)
        }
    }
    return ans
}