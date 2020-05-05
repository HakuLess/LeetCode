package leetcode.contest.cur.c185

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5391()
    s.numOfArrays(2, 3, 1).print()
    s.numOfArrays(9, 1, 1).print()
    s.numOfArrays(50, 100, 25).print()
    s.numOfArrays(37, 17, 7).print()
}

class Solution5391 {

    fun numOfArrays(n: Int, m: Int, k: Int): Int {
        val mod = 1000000007L

        val dp = Array<Array<LongArray>>(n + 1) { Array(m + 1) { LongArray(k + 1) } }
        for (i in 1..m) {
            dp[1][i][1] = 1L
        }
        for (i in 1..n) {
            for (j in 1..m) {
                for (l in 1..k) {
                    dp[i][j][l] = (dp[i][j][l] + j * dp[i - 1][j][l]) % mod
                    for (o in 1 until j) {
                        dp[i][j][l] = (dp[i][j][l] + dp[i - 1][o][l - 1]) % mod
                    }
                }
            }
        }
        var ans = 0L
        for (i in 1..m) {
            ans = (ans + dp[n][i][k]) % mod
        }
        return ans.toInt()
    }
//    val mod = 1000000007L
//    var count = 0
//    var up = 0
//    var addUp = 0
//
//    val seen = HashMap<String, Long>()
//    fun numOfArrays(n: Int, m: Int, k: Int): Int {
//        count = n
//        up = m
//        addUp = k
//        if (m < k) {
//            return 0
//        }
//        var ans = 0L
//        for (i in 1..up) {
//            ans += helper(1, 1, i)
//            ans %= mod
//        }
//        return ans.toInt()
//    }
//
//    private fun helper(size: Int, add: Int, max: Int): Long {
//        val key = "$size, $add, $max"
//        if (key in seen) {
//            return seen[key]!!
//        }
//        if (add > addUp) {
//            return 0L
//        }
//        if (size == count) {
//            return if (add == addUp) {
//                1
//            } else {
//                0
//            }
//        }
//        var ans = 0L
//        for (i in 1..up) {
//            ans += helper(size + 1, if (i > max) add + 1 else add, maxOf(i, max))
//            ans %= mod
//        }
////        println("$size  $add  $max  : $ans")
//        seen[key] = ans
//        return ans
//    }
}