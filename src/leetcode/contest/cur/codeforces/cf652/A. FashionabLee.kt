package leetcode.contest.cur.cf652

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val cur = readLine()!!.toInt()
        if ((cur % 4) == 0) {
            println("YES")
        } else {
            println("NO")
        }
    }
}