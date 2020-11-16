package leetcode.contest.cur.codeforces.kh5

import kotlin.math.abs

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val x = readLine()!!.toInt()
        val array = readLine()!!.split(" ").map { it.toLong() }.toLongArray()
        var max = 0L
        array.toHashSet().forEach { cur ->
            max = maxOf(max, cur * array.count { it >= cur })
        }
        println(max)
    }
}