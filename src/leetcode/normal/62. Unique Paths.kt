package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    uniquePaths(20, 20).print()
}

fun uniquePaths(m: Int, n: Int): Long {
    if (m == 0 || n == 0) {
        return 0
    }
    if (m == 1 || n == 1) {
        return 1
    }

    val x = m + 1
    val y = n + 1
    val dp = Array(x) { LongArray(y) }
    dp[0] = LongArray(y) { 0 }
    dp[1] = LongArray(y) { 1 }
    dp.forEach {
        it[0] = 0
        it[1] = 1
    }

    for (i in 1 until x) {
        for (j in 1 until y) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        }
    }

    return dp[m][n]
}