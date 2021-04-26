package leetcode.normal

import java.util.*

class Solution368 {
    fun largestDivisibleSubset(nums: IntArray): List<Int> {
        val n = nums.size
        nums.sort()

        val dp = IntArray(n) { 1 }
        var maxSize = 1
        var maxVal = dp[0]
        for (i in 1 until n) {
            for (j in 0 until i) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = maxOf(dp[i], dp[j] + 1)
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i]
                maxVal = nums[i]
            }
        }
        val res = ArrayList<Int>()
        if (maxSize == 1) {
            res.add(nums[0])
            return res
        }
        var i = n - 1
        while (i >= 0 && maxSize > 0) {
            if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                res.add(nums[i])
                maxVal = nums[i]
                maxSize--
            }
            i--
        }
        return res
    }
}