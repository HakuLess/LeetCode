package leetcode.contest.cur.atcoder.abc177

fun main(args: Array<String>) {
    val a = readLine()!!.split(' ').map { it.toLong() }
    if (a[1] * a[2] >= a[0]) println("Yes") else println("No")
}