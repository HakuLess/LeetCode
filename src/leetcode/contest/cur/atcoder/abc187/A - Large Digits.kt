package leetcode.contest.cur.atcoder.abc187

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map { it.toString() }
    println(maxOf(a.map { it - '0' }.sum(), b.map { it - '0' }.sum()))
}