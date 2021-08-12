package leetcode.contest.cur.cf654

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val (n, k) = readLine()!!.split(' ').map { it.toInt() }
        val dp = Array<IntArray>(n) { IntArray(n) }
        var cur = Pair(0, 0)
        for (c in 0 until k) {
            dp[cur.first][cur.second] = 1
            if (cur.first + 1 == n) {
                cur = Pair((cur.first + 1) % n, (cur.second + 2) % n)
            } else {
                cur = Pair((cur.first + 1) % n, (cur.second + 1) % n)
            }
        }
        val r = IntArray(n)
        val c = IntArray(n)
        for (i in 0 until n) {
            for (j in 0 until n) {
                r[i] += dp[i][j]
                c[j] += dp[i][j]
            }
        }
//        println("${r.maxOrNull()} ${r.minOrNull()} ${c.maxOrNull()} ${c.minOrNull()}")
        val ans = (r.maxOrNull()!! - r.minOrNull()!!) * (r.maxOrNull()!! - r.minOrNull()!!) + (c.maxOrNull()!! - c.minOrNull()!!) * (c.maxOrNull()!! - c.minOrNull()!!)
        println(ans)
        for (i in 0 until n) {
            println(dp[i].joinToString(""))
        }
    }
}