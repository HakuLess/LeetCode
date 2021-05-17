import leetcode.contest.utils.TreeNode

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
class Solution993 {
    fun isCousins(root: TreeNode, x: Int, y: Int): Boolean {
        fun dfs(root: TreeNode?, target: Int, depth: Int, parent: Int): Pair<Int, Int>? {
            if (root == null) return null
            if (target == root.`val`)
                return Pair(depth, parent)
            val l = dfs(root.left, target, depth + 1, root.`val`)
            val r = dfs(root.right, target, depth + 1, root.`val`)
            return l ?: r
        }
        val a = dfs(root, x, 0, -1)!!
        val b = dfs(root, y, 0, -1)!!
        return (a.first == b.first && a.second != b.second)
    }
}