package leetcode.normal

import leetcode.contest.utils.getLine
import leetcode.contest.utils.toPoint

class Solution149 {
    fun maxPoints(points: Array<IntArray>): Int {
        if (points.size == 1) return 1
        val n = points.size
        var ans = 0
        for (i in 0 until n - 1) {
            for (j in i + 1 until n) {
                val line = getLine(points[i].toPoint(), points[j].toPoint())
                var res = 0
                points.forEach {
                    if (it.toPoint() in line) res++
                }
                ans = maxOf(ans, res)
            }
        }
        return ans
    }
}