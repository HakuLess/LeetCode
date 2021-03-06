package leetcode.contest.cur.leetcode.b47

import kotlin.math.abs

class Solution5680 {
    fun nearestValidPoint(x: Int, y: Int, points: Array<IntArray>): Int {
        var ans = -1
        var cur = Int.MAX_VALUE
        for (i in points.indices) {
            if (points[i][0] == x || points[i][1] == y) {
                if (cur > abs(points[i][0] - x) + abs(points[i][1] - y)) {
                    ans = i
                    cur = abs(points[i][0] - x) + abs(points[i][1] - y)
                }
            }
        }
        return ans
    }
}