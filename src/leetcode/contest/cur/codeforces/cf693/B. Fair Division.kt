package leetcode.contest.cur.codeforces.cf693

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        var n = readLine()!!.toInt()
        val arr = readLine()!!.split(" ").map { it.toInt() }
        var c1 = 0
        var c2 = 0
        arr.forEach {
            if (it == 1) c1++
            else c2++
        }
        if (c1 % 2 != 0) {
            println("NO")
        } else {
            if (c1 == 0 && c2 % 2 != 0) {
                println("NO")
            } else {
                println("YES")
            }
        }
    }
}