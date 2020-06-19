package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution1021()
    s.maxScoreSightseeingPair(
            intArrayOf(8, 1, 5, 2, 6)
    ).print()
}

class Solution1021 {
    fun maxScoreSightseeingPair(A: IntArray): Int {
        val dp = IntArray(A.size)
        dp[0] = A[0] + 0
        for (i in 1..A.lastIndex) {
            dp[i] = maxOf(dp[i - 1], A[i] + i)
        }
        var ans = 0
        for (j in 1..A.lastIndex) {
            ans = maxOf(ans, dp[j - 1] + A[j] - j)
        }
        return ans
    }
}