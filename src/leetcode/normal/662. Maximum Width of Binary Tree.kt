package leetcode.normal

import leetcode.contest.utils.TreeNode
import leetcode.contest.utils.print
import leetcode.contest.utils.toTree
import kotlin.collections.HashMap


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
    val s = Solution662()
    s.widthOfBinaryTree(arrayOf(1, 3, 2, 5, 3, null, 9).toTree()).print()
//    s.widthOfBinaryTree(arrayOf(1, 1, 1, 1, 1, 1, 1, null, null, null, 1, null, null, null, null, 2, 2, 2, 2, 2, 2, 2, null, 2, null, null, 2, null, 2).toTree()).print()
}

class Solution662 {

    var ans = 0
    var left = HashMap<Int, Int>()

    fun widthOfBinaryTree(root: TreeNode?): Int {
        ans = 0
        dfs(root, 0, 0)
        return ans
    }

    fun dfs(root: TreeNode?, depth: Int, pos: Int) {
        if (root == null) return
        left.computeIfAbsent(depth) { pos }
        ans = maxOf(ans, pos - left[depth]!! + 1)
        dfs(root.left, depth + 1, 2 * pos)
        dfs(root.right, depth + 1, 2 * pos + 1)
    }
}