package leetcode.contest.cur.cf652

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val len = readLine()!!.toInt()
        val str = readLine()!!.toString()
        var s = ""
        var start = ""
        var startIndex = 0
        while (startIndex < len && str[startIndex] == '0') {
            start += str[startIndex]
            startIndex++
        }
        var endIndex = str.lastIndex
        var end = ""
        while (endIndex >= 0 && str[endIndex] == '1') {
            end += str[endIndex]
            endIndex--
        }
        val ans = if (endIndex > startIndex) "0" else ""

        println("$start$ans$end")
    }
}