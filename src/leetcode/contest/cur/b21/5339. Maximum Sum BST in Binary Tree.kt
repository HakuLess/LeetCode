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
    val s = Solution5339()
//    s.maxSumBST(arrayOf(1, 4, 3, 2, 4, 2, 5, null, null, null, null, null, null, 4, 6).toTree()).print()
    s.maxSumBST(arrayOf(9, 2, 3, null, 2, null, null, 3, null, -5, 4, null, 1, null, 10).toTree()).print()
}

class Solution5339 {
    var max = 0

    fun maxSumBST(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        dfs(root)
        return max
    }

    private fun dfs(root: TreeNode): Triple<Int, Int, Int>? {
        var l: Triple<Int, Int, Int>? = null
        var r: Triple<Int, Int, Int>? = null
        var b = true
        if (root.left != null) {
            l = dfs(root.left!!)
            if (l == null || l.first >= root.`val`) {
                b = false
            }
        }
        if (root.right != null) {
            r = dfs(root.right!!)
            if (r == null || r.second <= root.`val`) {
                b = false
            }
        }
        if (!b) {
            return null
        }
        val ans = Triple(maxOf(l?.first ?: root.`val`, root.`val`), minOf(r?.second ?: root.`val`, root.`val`),
                (l?.third ?: 0) + (r?.third ?: 0) + root.`val`)
        max = maxOf(max, ans.third)
        println(ans)
        return ans
    }
}