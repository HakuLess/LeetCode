package leetcode.normal

import leetcode.contest.utils.TreeNode
import kotlin.math.abs

class Solution1026 {

    private var maxDiff = 0
    fun maxAncestorDiff(root: TreeNode): Int {
        dfs(root, root.`val`, root.`val`)
        return maxDiff
    }

    private fun dfs(root: TreeNode?, maxP: Int, minP: Int) {
        var max = maxP
        var min = minP
        if (root == null) {
            return
        }
        maxDiff = maxOf(abs(max - root.`val`), maxDiff)
        maxDiff = maxOf(abs(min - root.`val`), maxDiff)
        max = maxOf(root.`val`, max)
        min = minOf(root.`val`, min)
        dfs(root.left, max, min)
        dfs(root.right, max, min)
    }
}