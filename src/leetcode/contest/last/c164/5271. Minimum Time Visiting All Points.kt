package leetcode.contest.last.c164

import kotlin.math.abs

class Solution5271 {
    fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
        if (points.isEmpty()) {
            return 0
        }
        var pre = points[0]
        var ans = 0
        for (i in 1..points.lastIndex) {
            val x = abs(points[i][0] - pre[0])
            val y = abs(points[i][1] - pre[1])
            ans += maxOf(x, y)
            pre = points[i]
        }
        return ans
    }
}