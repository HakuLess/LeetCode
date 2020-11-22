package leetcode.contest.cur.atcoder.abc184

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map { it.toLong() }
    val (c, d) = readLine()!!.split(' ').map { it.toLong() }
    println(a * d - b * c)
}