package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution188()
    s.maxProfit(2, intArrayOf(2, 4, 1)).print()
    s.maxProfit(2, intArrayOf(3, 2, 6, 5, 0, 3)).print()
}

class Solution188 {
    fun maxProfit(k: Int, prices: IntArray): Int {
        if (k == 0) {
            return 0
        }
        if (k > prices.size) {
            return maxProfitAny(prices)
        }
        val buy = IntArray(k) { Int.MIN_VALUE }
        val sell = IntArray(k) { 0 }
        prices.forEach { p ->
            for (i in 0 until k) {
                buy[i] = if (i == 0) {
                    maxOf(buy[i], -p)
                } else {
                    maxOf(buy[i], sell[i - 1] - p)
                }
                sell[i] = maxOf(sell[i], buy[i] + p)
            }
        }
        return sell[k - 1]
    }

    private fun maxProfitAny(prices: IntArray): Int {
        var max = 0
        for (i in 1 until prices.size) {
            if (prices[i] > prices[i - 1])
                max += prices[i] - prices[i - 1]
        }
        return max
    }
}