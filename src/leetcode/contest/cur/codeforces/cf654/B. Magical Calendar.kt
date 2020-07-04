package leetcode.contest.cur.cf654

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val (n, r) = readLine()!!.split(' ').map { it.toLong() }
        val min = minOf(n, r)
        if (r >= n) {
            println((min - 1) * min / 2 + 1)
        } else {
            println((min + 1) * min / 2)
        }
    }
}