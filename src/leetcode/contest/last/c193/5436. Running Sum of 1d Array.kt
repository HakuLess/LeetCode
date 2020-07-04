package leetcode.contest.last.c193

class Solution5436 {
    fun runningSum(nums: IntArray): IntArray {
        for (i in 1..nums.lastIndex) {
            nums[i] += nums[i - 1]
        }
        return nums
    }
}