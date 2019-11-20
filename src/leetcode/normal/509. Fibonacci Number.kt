package leetcode.normal

class Solution509 {
    fun fib(N: Int): Int {
        if (N == 0) {
            return 0
        }
        val dp = IntArray(N + 1)
        dp[0] = 0
        dp[1] = 1
        for (i in 2..N) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }
        return dp[N]
    }
}