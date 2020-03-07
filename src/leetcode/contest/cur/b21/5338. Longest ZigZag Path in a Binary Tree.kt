package leetcode.contest.cur.b21

import leetcode.contest.utils.TreeNode
import leetcode.contest.utils.print
import leetcode.contest.utils.toTree

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
fun main(args: Array<String>) {
    val s = Solution5338()
    s.longestZigZag(arrayOf(1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1, null, 1).toTree()).print()
}

class Solution5338 {
    private val seen = HashMap<Pair<TreeNode, Int>, Int>()
    fun longestZigZag(root: TreeNode?): Int {
        return helper(root, 0) - 1
    }

    private fun helper(root: TreeNode?, a: Int): Int {
        if (root == null) {
            return 0
        }
        if (Pair(root, a) in seen) {
            return seen[Pair(root, a)]!!
        }
        var ans = 0
        when (a) {
            0 -> {
                val a = helper(root.left, 1) + 1
                val b = helper(root.right, 2) + 1
                val c = helper(root.left, 0)
                val d = helper(root.right, 0)
                ans = intArrayOf(a, b, c, d).max()!!
            }
            1 -> {
                ans = helper(root.right, 2) + 1
            }
            else -> {
                ans = helper(root.left, 1) + 1
            }
        }
        seen[Pair(root, a)] = ans
        return ans
    }
}