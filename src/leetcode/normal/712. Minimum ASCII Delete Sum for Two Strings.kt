package leetcode.normal

class Solution712 {
    fun minimumDeleteSum(s1: String, s2: String): Int {
        val dp = Array(s1.length + 1) { IntArray(s2.length + 1) }
        for (i in 1 until s1.length + 1) {
            dp[i][0] = dp[i - 1][0] + s1[i - 1].toInt()
        }
        for (i in 1 until s2.length + 1) {
            dp[0][i] = dp[0][i - 1] + s2[i - 1].toInt()
        }
        for (i in 1 until s1.length + 1) {
            val c1 = s1[i - 1]
            for (j in 1 until s2.length + 1) {
                val c2 = s2[j - 1]
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1]
                } else {
                    val b = dp[i - 1][j] + c1.toInt()
                    val c = dp[i][j - 1] + c2.toInt()
                    dp[i][j] = minOf(b, c)
                }
            }
        }
        return dp.last().last()
    }
}