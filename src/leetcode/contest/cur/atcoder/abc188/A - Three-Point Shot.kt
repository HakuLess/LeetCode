package leetcode.contest.cur.atcoder.abc188

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map { it.toInt() }
    val x = minOf(a, b)
    val y = maxOf(a, b)
    if (x + 3 > y) {
        println("Yes")
    } else {
        println("No")
    }
}