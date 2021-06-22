package leetcode.normal

import leetcode.contest.utils.print
import leetcode.contest.utils.subMatrix
import leetcode.contest.utils.sum
import leetcode.contest.utils.toMatrix


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
        val n = grid.size
        val m = grid[0].size
        if (n < 3 || m < 3) {
            return 0
        }
        var ans = 0
        val matrix = grid.toMatrix()
        for (i in 0 until n - 2) {
            for (j in 0 until m - 2) {
                val sub = matrix.subMatrix(i, j, 3, 3)
                if (sub.sum(from = Pair(0, 0), to = Pair(0, 2)) == 15L
                    && sub.sum(from = Pair(1, 0), to = Pair(1, 2)) == 15L
                    && sub.sum(from = Pair(2, 0), to = Pair(2, 2)) == 15L
                    && sub.sum(from = Pair(0, 0), to = Pair(2, 0)) == 15L
                    && sub.sum(from = Pair(0, 1), to = Pair(2, 1)) == 15L
                    && sub.sum(from = Pair(0, 2), to = Pair(2, 2)) == 15L
                    && sub.sum(from = Pair(0, 0), to = Pair(2, 2)) == 15L
                    && sub.sum(from = Pair(0, 2), to = Pair(2, 0)) == 15L
                ) {
                    if ((1..9).all { it in sub }) {
                        ans++
                    }
                }
            }
        }
        return ans
    }

    fun numMagicSquaresInside2(grid: Array<IntArray>): Int {
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