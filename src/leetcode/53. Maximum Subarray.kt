package leetcode

import kotlin.math.max

fun maxSubArray(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    } else if (nums.size == 1) {
        return nums[0]
    }

    val dp = IntArray(nums.size)
    dp[0] = nums[0]
    dp[1] = if (nums[0] > 0) {
        nums[0] + nums[1]
    } else {
        nums[1]
    }

    for (i in 2 until nums.size) {
        dp[i] = max(dp[i - 1] + nums[i], nums[i])
    }

    return dp.max()!!
}