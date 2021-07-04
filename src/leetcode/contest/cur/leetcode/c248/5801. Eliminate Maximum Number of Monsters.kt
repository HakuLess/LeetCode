package leetcode.contest.cur.leetcode.c248

import leetcode.contest.utils.print
import kotlin.math.ceil
import kotlin.math.floor

fun main(args: Array<String>) {
    val s = Solution5801()
    s.eliminateMaximum(intArrayOf(1, 1, 2, 3), intArrayOf(1, 1, 1, 1)).print()
    s.eliminateMaximum(intArrayOf(3, 2, 4), intArrayOf(5, 3, 2)).print()
}

class Solution5801 {
    fun eliminateMaximum(dist: IntArray, speed: IntArray): Int {
        val arr = arrayListOf<Int>()
        for (i in dist.indices) {
            arr.add(ceil(dist[i] / speed[i].toDouble()).toInt())
        }
        arr.sort()
        arr.joinToString().print()
        for (i in arr.indices) {
            if (i >= arr[i]) return i
        }
        return arr.size
    }
}