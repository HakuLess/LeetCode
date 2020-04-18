package leetcode.contest.cur.b24

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5372()
    s.minStartValue(intArrayOf(-3, 2, -3, 4, 2)).print()
}

class Solution5372 {
    fun minStartValue(nums: IntArray): Int {
        var min = 0
        var cur = 0
        nums.forEach {
            cur += it
            cur.print()
            min = minOf(cur, min)
        }
        min.print()
        return -min + 1
    }
}