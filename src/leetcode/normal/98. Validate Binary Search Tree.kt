package leetcode.normal

import leetcode.contest.utils.TreeNode
import leetcode.contest.utils.print

/**
 * Created by HaKu on 21/03/2018.
 */

fun main(args: Array<String>) {
    val a = TreeNode(1)
    val b = TreeNode(2)
    val c = TreeNode(3)

    a.right = b
    b.left = c
    val s = Solution98()
    s.isValidBST(a).print()
}

class Solution98 {
    fun isValidBST(root: TreeNode?): Boolean {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    private fun isValidBST(root: TreeNode?, low: Long, high: Long): Boolean {
        return when {
            root == null -> true
            root.`val` in (low + 1) until high ->
                isValidBST(root.left, low, root.`val`.toLong()) && isValidBST(root.right, root.`val`.toLong(), high)
            else -> false
        }
    }
}