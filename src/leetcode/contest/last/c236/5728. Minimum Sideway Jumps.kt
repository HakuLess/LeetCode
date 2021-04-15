package leetcode.contest.last.c236

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5728()
    s.minSideJumps(intArrayOf(0, 1, 2, 3, 0)).print()
}

class Solution5728 {
    fun minSideJumps(obstacles: IntArray): Int {
        val dp = Array<IntArray>(3) { IntArray(obstacles.size) { Int.MAX_VALUE / 2 } }
        dp[1][0] = 0
        dp[0][0] = 1
        dp[2][0] = 1
        for (i in 1 until obstacles.size) {
            for (j in 0 until 3) {
                if (obstacles[i] != j + 1) {
                    dp[j][i] = dp[j][i - 1]
                }
            }
            for (j in 0 until 3) {
                if (obstacles[i] != j + 1) {
                    dp[j][i] = minOf(dp[j][i], dp[(j + 1) % 3][i] + 1, dp[(j + 2) % 3][i] + 1)
                }
            }
        }
        return minOf(dp[0].last(), dp[1].last(), dp[2].last())
    }
}