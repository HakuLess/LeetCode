package leetcode.contest.cur.c189

import kotlin.math.sqrt

class Solution5415 {

    var prec = 1e-8

    fun numPoints(points: Array<IntArray>, r: Int): Int {
        val n = points.size
        if (n == 1) {
            return 1
        }
        var ans = count(points, points[0][0].toDouble(), points[0][1].toDouble(), r)
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    continue
                }
                val mx = (points[i][0] + points[j][0]) / 2.0
                val my = (points[i][1] + points[j][1]) / 2.0
                var dirX = points[i][0] - points[j][0].toDouble()
                var dirY = points[i][1] - points[j][1].toDouble()
                val sqr = sqrt(dirX * dirX + dirY * dirY)
                dirX /= sqr
                dirY /= sqr
                val h = sqrt(r * r - sqr / 2 * sqr / 2)
                val moveX = -dirY
                val moveY = dirX
                val centerX = mx + moveX * h
                val centerY = my + moveY * h
                val cnt = count(points, centerX, centerY, r)
                ans = maxOf(ans, cnt)
            }
        }
        return ans
    }

    fun count(points: Array<IntArray>, x: Double, y: Double, r: Int): Int {
        var ans = 0
        for (pt in points) {
            val dx = x - pt[0]
            val dy = y - pt[1]
            if (dx * dx + dy * dy <= r * r + prec) {
                ans++
            }
        }
        return ans
    }
}