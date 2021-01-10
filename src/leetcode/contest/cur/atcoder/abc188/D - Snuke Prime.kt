package leetcode.contest.cur.atcoder.abc188

import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    val (n, c) = readLine()!!.split(' ').map { it.toInt() }
    val list = ArrayList<Pair<Long, Long>>()
    repeat(n) {
        val (a, b, c) = readLine()!!.split(' ').map { it.toLong() }
        list.add(Pair(a, c))
        list.add(Pair(b + 1, -c))
    }
    list.sortBy { it.first }
    var ans = 0L
    var cur = Pair(0L, 0L)
    for (i in list.indices) {
        val next = Pair(list[i].first, cur.second + list[i].second)
        ans += minOf(cur.second, c.toLong()) * (next.first - cur.first)
        cur = next
    }
    println(ans)
}