package leetcode.contest.cur.cf653

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        var x = readLine()!!.toInt()
        var a3 = 0
        var a2 = 0
        while (x % 3 == 0) {
            x /= 3
            a3++
        }
        while (x % 2 == 0) {
            x /= 2
            a2++
        }
        if (x != 1) println(-1)
        else if (a3 < a2) println(-1)
        else println(a3 + a3 - a2)
    }
}