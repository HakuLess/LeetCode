package leetcode.contest.cur.atcoder.abc188

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(' ').map { it.toInt() }
    val b = readLine()!!.split(' ').map { it.toInt() }
    var ans = 0
    for (i in 0 until n) {
        ans += a[i] * b[i]
    }
    if (ans == 0) {
        println("Yes")
    } else {
        println("No")
    }
}