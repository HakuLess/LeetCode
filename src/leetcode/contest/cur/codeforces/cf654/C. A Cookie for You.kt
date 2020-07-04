package leetcode.contest.cur.cf654

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val (a, b, n, m) = readLine()!!.split(' ').map { it.toLong() }
        if (n + m <= a + b && m <= minOf(a, b)) {
            println("Yes")
        } else {
            println("No")
        }
    }
}