package leetcode.contest.c135

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution5047()
    s.minScoreTriangulation(
            intArrayOf(1, 2, 4, 4)
    ).print()
//    s.minScoreTriangulation(
//            intArrayOf(3, 7, 4, 5)
//    ).print()
//
//    s.minScoreTriangulation(
//            intArrayOf(1, 3, 1, 1, 4, 5)
//    ).print()
}

class Solution5047 {
    fun minScoreTriangulation(A: IntArray): Int {
        val n = A.size
        val dp = Array(n) { IntArray(n) }
        for (j in 2 until n) {
            for (i in j - 2 downTo 0) {
                dp[i][j] = Integer.MAX_VALUE
                for (k in i + 1 until j) {
                    dp[i][j] = minOf(dp[i][j], dp[i][k] + dp[k][j] + A[i] * A[j] * A[k])
                }
            }
        }
        return dp[0][n - 1]
    }
}