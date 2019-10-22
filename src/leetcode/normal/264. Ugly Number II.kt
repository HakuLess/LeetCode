package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution264()
    s.nthUglyNumber(23).print()
    s.nthUglyNumber(10).print()
}

class Solution264 {
    fun nthUglyNumber(n: Int): Int {
        var x2 = 0
        var x3 = 0
        var x5 = 0

        val dp = IntArray(n + 1)
        dp[0] = 1
        for (i in 1..n) {
            val min = minOf(dp[x2] * 2, dp[x3] * 3, dp[x5] * 5)
            dp[i] = min
            if (min == dp[x2] * 2) {
                x2++
            }
            if (min == dp[x3] * 3) {
                x3++
            }
            if (min == dp[x5] * 5) {
                x5++
            }
        }
        dp.print()
        return dp[n - 1]
    }
}