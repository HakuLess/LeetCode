package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution495()
    s.findPoisonedDuration(intArrayOf(1, 4), 2).print()
    s.findPoisonedDuration(intArrayOf(1, 2), 2).print()
}

class Solution495 {
    fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
        if (timeSeries.isEmpty()) {
            return 0
        }
        var ans = 0
        var start = timeSeries[0]
        var end = start + duration

        for (i in 1 until timeSeries.size) {
            if (timeSeries[i] <= end) {
                end = timeSeries[i] + duration
            } else {
                ans += end - start
                start = timeSeries[i]
                end = timeSeries[i] + duration
            }
        }
        ans += end - start

        return ans
    }
}