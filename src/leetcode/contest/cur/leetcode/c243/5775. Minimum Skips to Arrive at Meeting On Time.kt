package leetcode.contest.cur.leetcode.c243

import kotlin.math.ceil

// DP
class Solution5775 {
    fun minSkips(dist: IntArray, speed: Int, hoursBefore: Int): Int {
        val eps = 1e-8
        val n = dist.size
        val dp = Array<DoubleArray>(n + 1) { DoubleArray(n + 1) { Double.MAX_VALUE } }
        dp[0][0] = 0.0
        for (i in 1 until n + 1) {
            for (j in 0..i) {
                if (i != j) {
                    dp[i][j] = minOf(dp[i][j], ceil(dp[i - 1][j] + dist[i - 1].toDouble() / speed - eps))
                }
                if (j != 0) {
                    dp[i][j] = minOf(dp[i][j], dp[i - 1][j - 1] + dist[i - 1].toDouble() / speed)
                }
            }
        }
        for (j in 0..n) {
            if (dp[n][j] < hoursBefore + eps) {
                return j
            }
        }
        return -1
    }
}