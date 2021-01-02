package leetcode.contest.cur.atcoder.abc187

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val edge = Array<BooleanArray>(20) { BooleanArray(20) }
    repeat(m) {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() }
        edge[a - 1][b - 1] = true
        edge[b - 1][a - 1] = true
    }
    val dp = IntArray(1 shl n)
    for (i in 1 until (1 shl n)) {
        dp[i] = 1
        for (j in 0 until n) {
            for (k in j + 1 until n) {
                if (i and (1 shl j) != 0 && i and (1 shl k) != 0) {
                    if (!edge[j][k]) {
                        dp[i] = Int.MAX_VALUE
                    }
                }
            }
        }
        var j = (i - 1) and i
        while (j != 0) {
            dp[i] = minOf(dp[i], dp[j] + dp[i xor j])
            j = j - 1 and i
        }
    }
    println(dp.last())
}