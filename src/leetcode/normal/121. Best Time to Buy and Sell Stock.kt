package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution121()
    val intArray = intArrayOf(14, 4)
    s.maxProfit(intArray).print()
}

class Solution121 {
    fun maxProfit(prices: IntArray): Int {
        var min = Integer.MAX_VALUE
        var ans = 0
        for (i in prices.indices) {
            min = minOf(min, prices[i])
            ans = maxOf(ans, prices[i] - min)
        }
        return ans
    }
}