package leetcode.normal

class Solution413 {
    fun numberOfArithmeticSlices(nums: IntArray): Int {
        if (nums.size < 3) {
            return 0
        }
        val dp = IntArray(nums.size)
        dp[0] = 0
        dp[1] = 0
        for (i in 2 until nums.size) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1
            } else {
                dp[i] = 0
            }
        }
        return dp.sum()
    }
}