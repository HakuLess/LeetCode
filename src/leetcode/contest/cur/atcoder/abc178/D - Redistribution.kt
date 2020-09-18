package leetcode.contest.cur.atcoder.abc178

import java.math.BigInteger

fun main(args: Array<String>) {
    val mod = (1e9 + 7).toInt()
    val s = readLine()!!.toInt()
    val dp = Array(2001) { 0 }
    dp[3] = 1
    for (i in 4..s) {
        dp[i] = (dp[i - 3] + dp[i - 1]) % mod
    }
    println(dp[s])
}