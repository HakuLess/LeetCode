package leetcode.normal

import leetcode.contest.utils.TreeNode

class Solution637 {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        val l = arrayListOf<ArrayList<Long>>()
        fun dfs(root: TreeNode?, level: Int) {
            if (root == null) return
            if (l.size < level + 1) {
                l.add(arrayListOf())
            }
            l[level].add(root.`val`.toLong())
            dfs(root.left, level + 1)
            dfs(root.right, level + 1)
        }
        dfs(root, 0)
        return l.map {
            it.sum().toDouble() / it.size
        }.toDoubleArray()
    }
}