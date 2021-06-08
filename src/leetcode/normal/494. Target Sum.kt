package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution494()
    s.findTargetSumWays(intArrayOf(1, 1, 1, 1, 1), 3).print()
}

class Solution494 {
    fun findTargetSumWays(nums: IntArray, S: Int): Int {
        val sum = nums.sum()
        if (sum < S || sum % 2 != S % 2) {
            return 0
        }
        val target = (sum + S) / 2
        val dp = IntArray(target + 1)
        dp[0] = 1
        for (n in nums) {
            for (i in target downTo n) {
                dp[i] += dp[i - n]
            }
        }
        dp.print()
        return dp[target]
    }
}