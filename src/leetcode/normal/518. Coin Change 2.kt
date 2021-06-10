package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution518()
    s.change(5, intArrayOf(1, 2, 5)).print()
    s.change(3, intArrayOf(2)).print()
    s.change(10, intArrayOf(10)).print()
}

class Solution518 {
    fun change(amount: Int, coins: IntArray): Int {
        val dp = IntArray(amount + 1) { 0 }
        dp[0] = 1
        for (i in coins.indices) {
            for (j in coins[i]..dp.lastIndex) {
                dp[j] += dp[j - coins[i]]
            }
        }
        return dp[amount]
    }
}