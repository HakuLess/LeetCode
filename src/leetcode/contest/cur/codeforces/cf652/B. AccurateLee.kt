package leetcode.contest.cur.cf652

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val len = readLine()!!.toInt()
        val str = readLine()!!.toString()
        if (str.indexOf("10") == -1) {
            println(str)
            continue
        }
        var startIndex = 0
        while (startIndex < len && str[startIndex] == '0') {
            startIndex++
        }
        var endIndex = str.lastIndex
        while (endIndex >= 0 && str[endIndex] == '1') {
            endIndex--
        }
        println("${str.substring(IntRange(0, startIndex - 1))}0${str.substring(endIndex + 1, str.length)}")
    }
}