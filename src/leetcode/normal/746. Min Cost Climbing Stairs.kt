package leetcode.normal

import leetcode.contest.utils.print

class Solution746 {
    fun minCostClimbingStairs(cost: IntArray): Int {
        if (cost.isEmpty()) {
            return 0
        } else if (cost.size == 1) {
            return cost[0]
        }
        val dp = IntArray(cost.size + 1)
        dp[0] = 0
        dp[1] = cost[0]
        for (i in 1 until cost.size) {
            dp[i + 1] = minOf(dp[i], dp[i - 1]) + cost[i]
        }
        dp.print()
        return minOf(dp[cost.size], dp[cost.size - 1])
    }
}