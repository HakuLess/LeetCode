package leetcode.contest.last.c250

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5814()
    s.addRungs(intArrayOf(4, 6), 1).print()
}

class Solution5814 {
    fun addRungs(rungs: IntArray, dist: Int): Int {
        var cur = 0
        var ans = 0
        for (rung in rungs) {
            ans += (rung - cur - 1) / dist
            cur = rung
        }
        return ans
    }
}