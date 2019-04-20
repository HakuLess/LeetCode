package leetcode.normal

import leetcode.TreeNode
import java.util.*
import kotlin.collections.HashSet

fun postorderTraversal(root: TreeNode?): List<Int> {
    if (root == null) {
        return emptyList()
    }
    val ans = arrayListOf<Int>()
    val stack = Stack<TreeNode?>()
    stack.push(root)
    val hashSet = HashSet<TreeNode?>()

    while (stack.isNotEmpty()) {
        val item = stack.pop()
        if (item == null) {

        } else if ((item.left == null || item.left in hashSet) &&
                (item.right == null || item.right in hashSet)) {
            ans.add(item.`val`)
            hashSet.add(item)
        } else {
            stack.push(item)
            stack.push(item.right)
            stack.push(item.left)
        }
    }

    return ans
}