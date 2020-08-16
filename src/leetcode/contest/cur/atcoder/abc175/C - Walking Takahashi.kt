package leetcode.contest.cur.atcoder.abc175

import kotlin.math.abs

fun main(args: Array<String>) {
    var (x, k, d) = readLine()!!.toString().split(' ').map { abs(it.toLong()) }
    var ans = 0L
    if (k >= x / d) {
        k -= x / d
        x -= x / d * d
        k %= 2
    }
    println(abs(x - d * k))
}