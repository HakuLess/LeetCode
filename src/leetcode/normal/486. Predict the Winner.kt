package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution486()
    s.PredictTheWinner(intArrayOf(1, 5, 2)).print()
}

class Solution486 {
    fun PredictTheWinner(nums: IntArray): Boolean {
        val n = nums.size
        val sum = nums.sum()
        val dp = Array(n) { IntArray(n) }
        for (j in 0 until n) {
            var curSum = 0
            for (i in j downTo 0) {
                curSum += nums[i]
                if (i == j) {
                    dp[i][j] = nums[i]
                } else {
                    dp[i][j] = maxOf(curSum - dp[i][j - 1], curSum - dp[i + 1][j])
                }
            }
        }
        return dp[0][n - 1] * 2 >= sum
    }
}