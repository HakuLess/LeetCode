package leetcode.contest.cur.codeforces.kh7

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val (n, k) = readLine()!!.split(" ").map { it.toInt() }
        val arr = ArrayList(readLine()!!.map { it - '0' })
        var cur = 0
        while (1 in arr) {
            arr.removeAt(cur)
            cur += k - 1
            if (arr.isEmpty()) break
            cur %= arr.size
        }
        println(n - arr.size)
    }
}