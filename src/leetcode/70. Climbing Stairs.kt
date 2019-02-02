package leetcode

fun climbStairs(n: Int): Int {
    if (n == 0 || n == 1) {
        return 1
    }
    val dp = IntArray(n)
    dp[0] = 1
    dp[1] = 2
    for (i in 2 until n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    return dp[n - 1]
}