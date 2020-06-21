package leetcode.normal

import leetcode.contest.utils.TreeNode
import leetcode.contest.utils.print
import leetcode.contest.utils.toTree

fun main(args: Array<String>) {
    val s = Solution124()
    s.maxPathSum(arrayOf(1, 2, 3).toTree()).print()
    s.maxPathSum(arrayOf(-10, 9, 20, null, null, 15, 7).toTree()).print()
    s.maxPathSum(arrayOf(-3).toTree()).print()
    s.maxPathSum(arrayOf(2, -1).toTree()).print()
    s.maxPathSum(arrayOf(-2, -1).toTree()).print()
    s.maxPathSum(arrayOf(1, 2, null, 3, null, 4, null, 5).toTree()).print()
    s.maxPathSum(arrayOf(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1).toTree()).print()
}

class Solution124 {
    var ans = Int.MIN_VALUE
    val map = HashMap<TreeNode, Int>()
    fun maxPathSum(root: TreeNode?): Int {
        ans = Int.MIN_VALUE
        helper(root)
        return ans
    }

    private fun helper(root: TreeNode?): Int {
        if (map.containsKey(root)) {
            return map[root]!!
        }
        if (root == null) {
            return 0
        }
        val left = helper(root.left)
        val right = helper(root.right)
        ans = maxOf(ans, left + right + root.`val`)
        val cur = maxOf(
                maxOf(left + root.`val`, 0),
                maxOf(right + root.`val`, 0)
        )
        map[root] = cur
        return cur
    }
}