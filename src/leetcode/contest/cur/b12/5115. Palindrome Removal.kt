package leetcode.contest.cur.b12

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5115()
    s.minimumMoves(intArrayOf(1, 2)).print()
}

class Solution5115 {

    fun minimumMoves(arr: IntArray): Int {
        if (arr.isEmpty()) {
            return 0
        }
        val n = arr.size
        val dp = Array(n + 1) { IntArray(n + 1) { 0 } }
        for (i in 0..n) {
            dp[i][i] = 1
        }

        for (len in 2..n) {
            var i = 0
            var j = len - 1
            while (j < n) {
                dp[i][j] = 1 + dp[i + 1][j]
                if (arr[i] == arr[i + 1]) {
                    dp[i][j] = minOf(1 + dp[i + 2][j], dp[i][j])
                }
                for (k in i + 2..j) {
                    if (arr[i] == arr[k]) {
                        dp[i][j] = minOf(dp[i + 1][k - 1] + dp[k + 1][j], dp[i][j])
                    }
                }
                i++
                j++
            }
        }

        return dp[0][n - 1]
    }
}