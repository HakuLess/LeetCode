package leetcode.contest.cur

import leetcode.contest.utils.print


fun main(args: Array<String>) {
    val s = Solution840()
    s.numMagicSquaresInside(
            arrayOf(
                    intArrayOf(4, 3, 8, 4),
                    intArrayOf(9, 5, 1, 9),
                    intArrayOf(2, 7, 6, 2)
            )
    ).print()
}

class Solution840 {
    fun numMagicSquaresInside(grid: Array<IntArray>): Int {
        if (grid.size < 3 || grid[0].size < 3) {
            return 0
        }
        var ans = 0
        val n = grid.size
        val m = grid[0].size

        for (i in 1 until n - 1) {
            for (j in 1 until m - 1) {
                if (isT(i, j, grid)) {
                    ans++
                }
            }
        }
        return ans
    }

    private fun isT(i: Int, j: Int, grid: Array<IntArray>): Boolean {
        if (grid[i][j] == 5) {
//            (grid[i - 1][j - 1] + grid[i][j] + grid[i + 1][j + 1]).print()
//            (grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1]).print()
//            (grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1]).print()
//            (grid[i][j - 1] + grid[i][j] + grid[i][j + 1]).print()
//            (grid[i + 1][j - 1] + grid[i + 1][j] + grid[i + 1][j + 1]).print()
//            (grid[i + 1][j - 1] + grid[i][j] + grid[i - 1][j + 1]).print()
            if (grid[i - 1][j - 1] + grid[i][j] + grid[i + 1][j + 1] == 15 &&
                    grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1] == 15 &&
                    grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1] == 15 &&
                    grid[i][j - 1] + grid[i][j] + grid[i][j + 1] == 15 &&
                    grid[i + 1][j - 1] + grid[i + 1][j] + grid[i + 1][j + 1] == 15 &&
                    grid[i + 1][j - 1] + grid[i][j] + grid[i - 1][j + 1] == 15 &&
                    grid[i - 1][j - 1] + grid[i][j - 1] + grid[i + 1][j - 1] == 15 &&
                    grid[i - 1][j] + grid[i][j] + grid[i + 1][j] == 15 &&
                    grid[i - 1][j + 1] + grid[i][j + 1] + grid[i + 1][j + 1] == 15
            ) {
                val seen = hashSetOf<Int>()
                for (p in -1..1) {
                    for (q in -1..1) {
                        if (grid[i + p][j + q] in seen || grid[i + p][j + q] !in 1..9) {
                            return false
                        } else {
                            seen.add(grid[i + p][j + q])
                        }
                    }
                }
                return true
            }
        }
        return false
    }
}