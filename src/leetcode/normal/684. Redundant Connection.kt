package leetcode.normal

import leetcode.contest.utils.UFS

class Solution684 {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val ufs = UFS(edges.size)
        for (i in 0 until edges.size) {
            val x = edges[i][0] - 1
            val y = edges[i][1] - 1
            if (ufs.find(x) == ufs.find(y)) {
                return intArrayOf(x + 1, y + 1)
            }
            ufs.union(x, y)

        }
        return intArrayOf()
    }
}