package leetcode.contest.cur.atcoder.abc184

import kotlin.math.abs

fun main(args: Array<String>) {
    val (r1, c1) = readLine()!!.split(" ").map { it.toInt() }
    val (r2, c2) = readLine()!!.split(" ").map { it.toInt() }
    val r = abs(r2 - r1)
    val c = abs(c2 - c1)
    if (r == 0 && c == 0) println(0)
    else if (r == c || r + c <= 3) println(1)
    else if (r + c <= 6 || r % 2 == c % 2 || abs(r - c) <= 3) println(2)
    else println(3)
}