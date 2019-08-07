package leetcode.contest.last.c134

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution1035()
    s.maxUncrossedLines(
            intArrayOf(2, 5, 1, 2, 5),
            intArrayOf(10, 5, 2, 1, 5, 2))
            .print()
}

class Solution1035 {
    fun maxUncrossedLines(A: IntArray, B: IntArray): Int {
        val n = A.size
        val m = B.size
        val dp = Array(n + 1) { IntArray(m + 1) }
        for (i in 1..n) {
            for (j in 1..m) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1
                } else {
                    dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
                }
            }
        }
        dp.print()
        return dp[n][m]
    }
}