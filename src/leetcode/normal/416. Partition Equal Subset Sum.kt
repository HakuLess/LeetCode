package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution416()
//    s.canPartition(intArrayOf(1, 3, 5, 5)).print()
    s.canPartition(intArrayOf(100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100)).print()
}

class Solution416 {
    fun canPartition(nums: IntArray): Boolean {
        val n = nums.size
        if (n < 2) {
            return false
        }
        if (nums.sum() % 2 != 0) {
            return false
        }
        val target = nums.sum() / 2
        if (nums.max()!! > target) {
            return false
        }
        val dp = BooleanArray(target + 1)
        dp[0] = true
        for (i in 0 until n) {
            val num = nums[i]
            for (j in target downTo num) {
                dp[j] = dp[j] or dp[j - num]
            }
        }
        return dp[target]
    }
}