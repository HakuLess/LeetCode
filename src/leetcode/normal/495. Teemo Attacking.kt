package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution495()
    s.findPoisonedDuration(intArrayOf(1, 4), 2).print()
    s.findPoisonedDuration(intArrayOf(1, 2), 2).print()
}

class Solution495 {
    fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
        if (timeSeries.isEmpty()) return 0
        var ans = 0
        for (i in 0 until timeSeries.lastIndex) {
            ans += minOf(timeSeries[i + 1] - timeSeries[i], duration)
        }
        return ans + duration
    }
}