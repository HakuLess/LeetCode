package leetcode.contest.cur.cf652

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    val mod = 1000000007L
    val dp = LongArray(2000100)
    dp[3] = 4L
    dp[4] = 4L
    for (i in 5 until dp.lastIndex) {
        dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % mod
        if (i % 3 == 0) {
            dp[i] = (dp[i] + 4) % mod
        }
    }
    for (i in 0 until t) {
        val cur = readLine()!!.toInt()
        println("${dp[cur]}")
    }
}