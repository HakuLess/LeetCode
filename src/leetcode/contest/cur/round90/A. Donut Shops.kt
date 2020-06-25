package leetcode.contest.cur.round90

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
        val ans0 = if (c <= a) {
            -1
        } else {
            1
        }
        val ans1 = if (c.toDouble() / b.toDouble() >= a) {
            -1
        } else b
        println("$ans0 $ans1")
    }
}