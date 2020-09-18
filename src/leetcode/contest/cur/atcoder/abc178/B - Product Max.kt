package leetcode.contest.cur.atcoder.abc178

fun main(args: Array<String>) {
    val (a, b, c, d) = readLine()!!.split(' ').map { it.toLong() }
    var max = Long.MIN_VALUE
    max = maxOf(max, a * c)
    max = maxOf(max, b * c)
    max = maxOf(max, a * d)
    max = maxOf(max, b * d)
    println(max)
}