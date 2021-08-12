package leetcode.contest.cur.atcoder.abc178

import kotlin.math.abs
import kotlin.math.max

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val list = List(n) {
        val (x, y) = readLine()!!.split(" ").map { it.toInt() }
        Pair(x, y)
    }
    fun dis(x: Pair<Int, Int>, y: Pair<Int, Int>): Int {
        return abs(x.first - y.first) + abs(x.second - y.second)
    }
    val maxPlus = list.maxByOrNull { it.first + it.second }!!
    val minPlus = list.minByOrNull { it.first + it.second }!!
    val maxMinus = list.maxByOrNull { it.first - it.second }!!
    val minMinus = list.minByOrNull { it.first - it.second }!!
    println(max(dis(maxPlus, minPlus), dis(maxMinus, minMinus)))
}