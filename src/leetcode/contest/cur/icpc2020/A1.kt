package leetcode.contest.cur.icpc2020

import leetcode.contest.utils.print

fun main(args: Array<String>) {
//    val t = readLine()!!.toInt()
    val ans = readLine()!!.split(" ").map {
        try {
            it.toInt()
        } catch (ex: Exception) {
            it.print()
            0
        }
    }.toIntArray()
    ans.sort()
    println(ans[0])
//    ans.filter { it <= 100 }.joinToString(" ").print()
    ans.joinToString(" ").print()
}