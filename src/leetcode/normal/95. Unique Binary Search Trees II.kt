package leetcode.normal

import leetcode.contest.utils.TreeNode
import java.util.LinkedList


fun generateTrees(n: Int): List<TreeNode?> {
    return if (n == 0) LinkedList() else helper(1, n)
}

private fun helper(start: Int, end: Int): List<TreeNode?> {
    val result = LinkedList<TreeNode?>()
    if (start > end) {
        result.add(null)
        return result
    }

    for (`val` in start..end) {
        val temp1 = helper(start, `val` - 1)
        val temp2 = helper(`val` + 1, end)
        for (i in temp1.indices) {
            for (j in temp2.indices) {
                val node = TreeNode(`val`)
                node.left = temp1[i]
                node.right = temp2[j]
                result.add(node)
            }
        }
    }
    return result
}