package leetcode.contest.cur.round90

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val s = readLine()!!.toString()
        val dp = IntArray(s.length) { 0 }
        var cur = 0
        var index = 0
        s.forEach {
            if (it == '-') {
                cur--
            } else {
                cur++
            }
            dp[index++] = cur
        }
        if (dp.all { it >= 0 }) {
            println(s.length)
            continue
        }
        var add = -dp.min()!!
        var ans = 0L
        var min = 0
        for (i in dp.indices) {
            ans += add + 1
            if (dp[i] < min) {
                min = dp[i]
                add--
            }
        }
        println(ans)
    }
}