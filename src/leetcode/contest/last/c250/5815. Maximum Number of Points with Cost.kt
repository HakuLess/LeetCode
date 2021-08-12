package leetcode.contest.last.c250

class Solution5815 {
    // 左侧、右侧数组
    fun maxPoints(points: Array<IntArray>): Long {
        val n = points.size
        val m = points[0].size

        var dp = points[0].map { it.toLong() }.toLongArray()
        for (i in 1 until n) {
            val next = LongArray(m)
            // 左侧最大值
            var lmax = 0L
            for (j in 0 until m) {
                lmax = maxOf(lmax - 1, dp[j])
                next[j] = maxOf(next[j], lmax)
            }
            // 右侧最大值
            var rmax = 0L
            for (j in m - 1 downTo 0) {
                rmax = maxOf(rmax - 1, dp[j])
                next[j] = maxOf(next[j], rmax)
            }
            for (j in 0 until m) {
                next[j] += points[i][j].toLong()
            }
            dp = next
        }

        return dp.maxOrNull()!!
    }
}