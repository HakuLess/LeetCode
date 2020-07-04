package leetcode.contest.cur.codeforces.gr9

import com.sun.source.util.Trees
import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val n = readLine()!!.toInt()
        val arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
        println(if (arr[0] < arr.last()) "YES" else "NO")
    }
}