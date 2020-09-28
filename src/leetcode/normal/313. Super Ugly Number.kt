package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution313()
    s.nthSuperUglyNumber(12, intArrayOf(2, 7, 13, 19)).print()
}

class Solution313 {
    fun nthSuperUglyNumber(n: Int, primes: IntArray): Int {
        val x = IntArray(primes.size)
        val dp = IntArray(n + 1)
        dp[0] = 1
        for (i in 1..n) {
            var min = Int.MAX_VALUE
            for (j in primes.indices) {
                min = minOf(min, dp[x[j]] * primes[j])
            }
            dp[i] = min
            for (j in primes.indices) {
                if (min == dp[x[j]] * primes[j]) {
                    x[j]++
                }
            }
        }
        dp.print()
        return dp[n - 1]
    }
}