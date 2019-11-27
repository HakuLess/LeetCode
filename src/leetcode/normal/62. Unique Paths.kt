package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution62()
    s.uniquePaths(20, 20).print()
}

class Solution62 {
    fun uniquePaths(m: Int, n: Int): Int {
        val path = IntArray(n) { 1 }
        for (i in 1 until m) {
            for (j in 1 until n) {
                path[j] = path[j - 1] + path[j]
            }
        }
        return path[n - 1]
    }
//    fun uniquePaths(m: Int, n: Int): Int {
//        if (m == 0 || n == 0) {
//            return 0
//        }
//        if (m == 1 || n == 1) {
//            return 1
//        }
//
//        val x = m + 1
//        val y = n + 1
//        val dp = Array(x) { LongArray(y) }
//        dp[0] = LongArray(y) { 0 }
//        dp[1] = LongArray(y) { 1 }
//        dp.forEach {
//            it[0] = 0
//            it[1] = 1
//        }
//
//        for (i in 1 until x) {
//            for (j in 1 until y) {
//                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
//            }
//        }
//
//        return dp[m][n].toInt()
//    }
}