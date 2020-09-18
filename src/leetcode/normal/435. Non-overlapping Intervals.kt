package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution435()
    s.eraseOverlapIntervals(arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(1, 3)
    )).print()

    s.eraseOverlapIntervals(arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 2),
            intArrayOf(1, 2)
    )).print()

    s.eraseOverlapIntervals(arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3)
    )).print()
}

class Solution435 {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        if (intervals.isEmpty()) return 0
        val sorted = intervals.sortedBy { it[1] }
        var end = sorted[0][1]
        var counter = 1
        for (i in 1..sorted.lastIndex) {
            if (sorted[i][0] >= end) {
                end = sorted[i][1]
                counter++
            }
        }
        return intervals.size - counter
    }
}