package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution123()
    s.maxProfit(intArrayOf(3, 3, 5, 0, 0, 3, 1, 4)).print()
    s.maxProfit(intArrayOf(1, 2, 3, 4, 5)).print()
}

class Solution123 {
    fun maxProfit(prices: IntArray): Int {
        var b0 = Int.MIN_VALUE
        var b1 = Int.MIN_VALUE
        var s0 = 0
        var s1 = 0
        prices.forEach {
            b0 = maxOf(b0, -it)
            s0 = maxOf(s0, b0 + it)
            b1 = maxOf(b1, s0 - it)
            s1 = maxOf(s1, b1 + it)
        }
        return s1
    }
}