package leetcode.contest.cur.atcoder.abc210

import leetcode.contest.utils.gcd

// 互联，GCD
fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val l = arrayListOf<Pair<Long, Long>>()
    repeat(m) {
        val (a, c) = readLine()!!.split(" ").map { it.toLong() }
        l.add(Pair(a, c))
    }
    l.sortBy { it.second }

    var g = n.toLong()
    var ans = 0L
    for ((a, c) in l) {
        val ng = gcd(g, a)
        ans += (g - ng) * c
        g = ng
    }
    if (g > 1) println(-1)
    else println(ans)
}