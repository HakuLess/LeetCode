package leetcode.contest.cur.b18

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5155()
    s.arrayRankTransform(intArrayOf(37, 12, 28, 9, 100, 56, 80, 5, 12)).print()
}

class Solution5155 {
    fun arrayRankTransform(arr: IntArray): IntArray {
        val sorted = arr.toSet().sorted()
        val map = HashMap<Int, Int>()
        for (i in sorted.indices) {
            map[sorted[i]] = i + 1
        }
        return arr.map {
            map[it]!!
        }.toIntArray()
    }
}