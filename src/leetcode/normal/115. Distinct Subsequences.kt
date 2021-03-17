package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution115()
    s.numDistinct("babgbag", "bag").print()
    s.numDistinct("rabbbit", "rabbit").print()
}

class Solution115 {
    fun numDistinct(s: String, t: String): Int {
        val m: Int = s.length
        val n: Int = t.length
        if (m < n) {
            return 0
        }
        val dp = Array(m + 1) { IntArray(n + 1) }
        for (i in 0..m) {
            dp[i][n] = 1
        }
        for (i in m - 1 downTo 0) {
            val sChar: Char = s[i]
            for (j in n - 1 downTo 0) {
                val tChar: Char = t[j]
                if (sChar == tChar) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j]
                } else {
                    dp[i][j] = dp[i + 1][j]
                }
            }
        }
        return dp[0][0]
    }
}