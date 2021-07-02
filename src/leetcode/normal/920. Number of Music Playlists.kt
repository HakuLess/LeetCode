package leetcode.normal

class Solution920 {
    fun numMusicPlaylists(n: Int, goal: Int, k: Int): Int {
        val mod = 1000000007
        val dp = Array(goal + 1) { LongArray(n + 1) }
        dp[0][0] = 1L
        for (i in 1..goal)
            for (j in 1..n) {
                dp[i][j] += dp[i - 1][j - 1] * (n - j + 1)
                dp[i][j] += dp[i - 1][j] * maxOf(j - k, 0)
                dp[i][j] = dp[i][j] % mod
            }
        return dp[goal][n].toInt()
    }
}