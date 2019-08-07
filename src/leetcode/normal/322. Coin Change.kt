package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution322()
    s.coinChange(intArrayOf(1, 2, 5), 11).print()
    s.coinChange(intArrayOf(2), 11).print()
}

class Solution322 {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { -1 }
        dp[0] = 0
        for (i in 1 until dp.size) {
            coins.forEach {
                if (i - it in 0..dp.lastIndex && dp[i - it] >= 0) {
                    if (dp[i] < 0) {
                        dp[i] = dp[i - it] + 1
                    } else {
                        dp[i] = minOf(dp[i - it] + 1, dp[i])
                    }
                }
            }
            dp.print()
        }
        return dp[amount]
    }
}