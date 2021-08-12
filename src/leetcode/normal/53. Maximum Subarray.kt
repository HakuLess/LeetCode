package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution53()
    s.maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)).print()
}

class Solution53 {
    fun maxSubArray(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        for (i in 1 until nums.size) {
            dp[i] = maxOf(dp[i - 1] + nums[i], nums[i])
        }
        return dp.maxOrNull()!!
    }
}