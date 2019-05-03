package leetcode.contest.c134

import leetcode.print

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
        val dp = Array(n) { IntArray(m) }
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (i == 0 || j == 0) {
                    if (A[i] == B[j]) {
                        dp[i][j] = 1
                    } else {
                        dp[i][j] = when {
                            i == 0 && j == 0 -> 0
                            j == 0 -> dp[i - 1][j]
                            else -> dp[i][j - 1]
                        }
                    }
                } else {
                    if (A[i] == B[j]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1
                    } else {
                        dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
                    }
                }

            }
        }
        dp.print()
        return dp[n - 1][m - 1]
    }
}