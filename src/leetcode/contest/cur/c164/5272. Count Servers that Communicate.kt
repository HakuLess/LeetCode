package leetcode.contest.cur.c164

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5272()
    s.countServers(arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0, 1)
    )).print()
}

class Solution5272 {
    fun countServers(grid: Array<IntArray>): Int {
        var ans = 0
        for (i in 0..grid.lastIndex) {
            for (j in 0..grid[0].lastIndex) {
                if (grid[i][j] == 1)
                    ans += if (checkGrid(grid, i, j)) 1 else 0
            }
        }
        return ans
    }

    private fun checkGrid(grid: Array<IntArray>, x: Int, y: Int): Boolean {
        for (i in 0..grid.lastIndex) {
            if (i != x && grid[i][y] == 1) {
                return true
            }
        }
        for (j in 0..grid[0].lastIndex) {
            if (j != y && grid[x][j] == 1) {
                return true
            }
        }
        return false
    }
}