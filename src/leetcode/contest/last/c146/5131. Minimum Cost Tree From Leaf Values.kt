package leetcode.contest.last.c146

class Solution5131 {
    fun mctFromLeafValues(arr: IntArray): Int {
        val n = arr.size
        val dp = Array(n) { IntArray(n) }
        val max = Array(n) { IntArray(n) }
        for (i in 0 until n) max[i][i] = arr[i]
        for (l in 2..n) {
            var i = 0
            while (i + l <= n) {
                val j = i + l - 1
                dp[i][j] = Int.MAX_VALUE
                max[i][j] = maxOf(max[i][j - 1], max[j][j])
                for (k in i until j) {
                    dp[i][j] = minOf(dp[i][j], dp[i][k] + dp[k + 1][j] + max[i][k] * max[k + 1][j])
                }
                ++i
            }
        }
        return dp[0][n - 1]
    }
}

