package leetcode.contest.cur.atcoder.abc210

fun main(args: Array<String>) {
    val (n, a, x, y) = readLine()!!.split(' ').map { it.toInt() }
    if (a >= n) println(n * x)
    else println(a * x + (n - a) * y)
}