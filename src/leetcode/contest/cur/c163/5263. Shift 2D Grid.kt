package leetcode.contest.cur.c163

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5263()
    s.shiftGrid(arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
    ), 1).print()
}

class Solution5263 {
    fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
        val m = grid.size
        val n = grid[0].size

        val ans = Array<IntArray>(m) { IntArray(n) }
        for (i in 0 until m) {
            for (j in 0 until n) {
                val l = (i * n + j + k) % (m * n)
                val ni = l / n
                val nj = l % n
                ans[ni][nj] = grid[i][j]
            }
        }
        return ans.map {
            it.map {
                it
            }
        }
    }
}