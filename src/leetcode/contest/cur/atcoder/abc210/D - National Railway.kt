package leetcode.contest.cur.atcoder.abc210

import kotlin.math.abs

// 两点的值 与 距离 * 倍数的和最小
fun main(args: Array<String>) {
    val (h, w, c) = readLine()!!.split(" ").map { it.toInt() }
    val matrix = ArrayList<List<Long>>()
    repeat(h) {
        matrix.add(readLine()!!.split(" ").map { it.toLong() })
    }
    var ans = Long.MAX_VALUE
    for (x0 in 0 until h) {
        for (y0 in 0 until w) {
            for (x1 in x0 until h) {
                for (y1 in y0 until w) {
                    if (x0 == x1 && y0 == y1) continue
                    ans = minOf(ans, matrix[x0][y0] + matrix[x1][y1] + c.toLong() * (abs(x1 - x0) + abs(y1 - y0)))
                }
            }
        }
    }
    println(ans)
}