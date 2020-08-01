package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution375()
    s.getMoneyAmount(15).print()
}

class Solution375 {

    fun getMoneyAmount(n: Int): Int {
        val dp = Array(n + 1) { IntArray(n + 1) { 0 } }
        for (k in 2..n) {
            for (i in 1..n - k + 1) {
                val j = i + k - 1
                var min = Int.MAX_VALUE / 2
                for (m in j - 1 downTo i) {
                    min = minOf(min, m + maxOf(dp[i][m - 1], dp[m + 1][j]))
                    dp[i][j] = min
                }
            }
        }

        dp.print()
        return dp[1][n]
    }
}