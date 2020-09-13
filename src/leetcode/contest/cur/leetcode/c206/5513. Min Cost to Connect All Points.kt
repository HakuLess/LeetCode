package leetcode.contest.cur.leetcode.c206

import leetcode.contest.utils.UFS
import leetcode.contest.utils.print
import kotlin.math.abs

fun main(args: Array<String>) {
    val s = Solution5513()
    s.minCostConnectPoints(arrayOf(
            intArrayOf(0, 0),
            intArrayOf(2, 2),
            intArrayOf(3, 10),
            intArrayOf(5, 2),
            intArrayOf(7, 0)
    )).print()
}

class Solution5513 {
    fun minCostConnectPoints(points: Array<IntArray>): Int {
        var ans = 0
        val ufs = UFS(points.size)
        val list = ArrayList<Triple<Int, Int, Int>>()
        for (i in points.indices) {
            for (j in points.indices) {
                if (i == j) continue
                val cur = abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1])
                list.add(Triple(i, j, cur))
            }
        }
        val sorted = list.sortedBy { it.third }
        for (i in sorted.indices) {
            if (ufs.union(sorted[i].first, sorted[i].second)) {
                ans += sorted[i].third
            }
        }
        return ans
    }
}