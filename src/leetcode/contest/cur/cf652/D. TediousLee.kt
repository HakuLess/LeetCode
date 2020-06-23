package leetcode.contest.cur.cf652

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    val mod = 1000000007
    val dp = IntArray(2000100)
    dp[3] = 4
    dp[4] = 4
    for (i in 5 until dp.lastIndex) {
        dp[i] = (dp[i - 2] * 3) % mod
    }
    for (i in 0 until t) {
        val cur = readLine()!!.toInt()
        println("${dp[cur]}")
    }
}