package leetcode.contest.cur.cf653

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val (x, y, n) = readLine()!!.split(" ").map { it.toInt() }
        val left = n % x
        if (left >= y) {
            println(n - left + y)
        } else {
            println(n - left + y - x)
        }
    }
}