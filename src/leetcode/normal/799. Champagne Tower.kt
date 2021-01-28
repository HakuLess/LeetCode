package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution799()
    s.champagneTower(100000009, 33, 17).print()
}

class Solution799 {
    fun champagneTower(poured: Int, query_row: Int, query_glass: Int): Double {
        val dp = Array(102) { DoubleArray(102) }
        dp[0][0] = poured.toDouble()
        for (r in 0..query_row) {
            for (c in 0..r) {
                val q = (dp[r][c] - 1.0) / 2.0
                if (q > 0) {
                    dp[r + 1][c] += q
                    dp[r + 1][c + 1] += q
                }
            }
        }
        return minOf(1.0, dp[query_row][query_glass])
    }
}