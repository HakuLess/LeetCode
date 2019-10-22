package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution837()
//    s.new21Game(10, 1, 10).print()
//    s.new21Game(6, 1, 10).print()
    s.new21Game(21, 17, 10).print()
//    s.new21Game(0, 0, 1).print()
//    s.new21Game(5710, 5070, 8516).print()
//    s.new21Game(1, 0, 1).print()
}

class Solution837 {

    fun new21Game(N: Int, K: Int, W: Int): Double {
        if (K == 0 || N >= K + W) {
            return 1.0
        }
        val dp = DoubleArray(N + 1) { 0.0 }
        dp[0] = 1.0
        var sum = 1.0
        for (i in 1..N) {
            dp[i] = sum / W
            if (i < K) {
                sum += dp[i]
            }
            if (i >= W) {
                sum -= dp[i - W]
            }
        }
        var ans = 0.0
        for (i in K until dp.size) {
            ans += dp[i]
        }
        return ans
    }
}