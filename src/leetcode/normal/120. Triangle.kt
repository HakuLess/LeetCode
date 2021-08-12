package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution120()
    s.minimumTotal(
            arrayListOf(
                    arrayListOf(2),
                    arrayListOf(3, 4),
                    arrayListOf(6, 5, 7),
                    arrayListOf(4, 1, 8, 3)
            )
    ).print()
}

class Solution120 {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val dp = IntArray(triangle.size) { 0 }
        var size = 0
        dp[0] = triangle[0][0]
        for (i in 1 until dp.size) {
            size++
            val temp = dp[size - 1]
            for (j in size downTo 0) {
                when (j) {
                    0 -> dp[j] += triangle[i][j]
                    size -> dp[j] += triangle[i][j] + temp
                    else -> dp[j] = triangle[i][j] + minOf(dp[j], dp[j - 1])
                }
            }
        }
        return dp.minOrNull()!!
    }
}