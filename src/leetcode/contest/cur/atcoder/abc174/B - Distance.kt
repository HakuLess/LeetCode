package leetcode.contest.cur.atcoder.abc174

fun main(args: Array<String>) {
    val (t, d) = readLine()!!.toString().split(' ').map { it.toLong() }
    var ans = 0
    for (i in 0 until t) {
        val (x, y) = readLine()!!.toString().split(' ').map { it.toLong() }
        if (x * x + y * y <= d * d) {
            ans++
        }
    }
    println(ans)
}