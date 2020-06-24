package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution221()
    s.maximalSquare(arrayOf(
            charArrayOf('1', '0', '1', '0', '0'),
            charArrayOf('1', '0', '1', '1', '1'),
            charArrayOf('1', '1', '1', '1', '1'),
            charArrayOf('1', '0', '0', '1', '0')
    )).print()
}

class Solution221 {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return 0
        }
        var maxSide = 0
        val rows: Int = matrix.size
        val columns: Int = matrix[0].size
        val dp = Array(rows) { IntArray(columns) }
        for (i in 0 until rows) {
            for (j in 0 until columns) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1
                    } else {
                        dp[i][j] = minOf(minOf(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1
                    }
                    maxSide = maxOf(maxSide, dp[i][j])
                }
            }
        }
        dp.print()
        return maxSide * maxSide
    }
}