package leetcode.contest.cur.leetcode.b54

import leetcode.contest.utils.sum
import leetcode.contest.utils.toMatrix

class Solution5202 {
    fun largestMagicSquare(grid: Array<IntArray>): Int {
        var ans = 0
        val m = grid.size
        val n = grid[0].size
        val matrix = grid.toMatrix()
        fun cal(i: Int, j: Int, k: Int) {
            val sum = matrix.sum(from = Pair(i, j), to = Pair(i + k, j))
            for (c in 0..k) {
                if (sum != matrix.sum(from = Pair(i, j + c), to = Pair(i + k, j + c))) return
                if (sum != matrix.sum(from = Pair(i + c, j), to = Pair(i + c, j + k))) return
            }
            if (sum != matrix.sum(from = Pair(i, j), to = Pair(i + k, j + k))) return
            if (sum != matrix.sum(from = Pair(i + k, j), to = Pair(i, j + k))) return
            ans = maxOf(ans, k)
        }

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                for (k in 0 until maxOf(n, m)) {
                    if (i + k in grid.indices && j + k in grid[0].indices) {
                        cal(i, j, k)
                    } else break
                }
            }
        }
        return ans + 1
    }
}