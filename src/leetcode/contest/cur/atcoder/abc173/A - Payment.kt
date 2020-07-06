package leetcode.contest.cur.atcoder.abc173

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    if (t % 1000 == 0) {
        println(0)
    } else {
        println(1000 - t % 1000)
    }
}