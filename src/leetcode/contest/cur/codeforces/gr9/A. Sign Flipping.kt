package leetcode.contest.cur.codeforces.gr9

import leetcode.contest.utils.print
import kotlin.math.abs

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val x = readLine()!!.toInt()
        val array = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
        var pos : Boolean? = null
        for (j in array.indices) {
            if (pos == null) {
                pos = array[j] >= 0
                continue
            } else {
                if (pos) {
                    array[j] = -abs(array[j])
                    pos = false
                } else {
                    array[j] = abs(array[j])
                    pos = true
                }
            }
        }
        println(array.joinToString(" "))
    }
}