package leetcode.contest.last.c183

class Solution5376 {
    fun minSubsequence(nums: IntArray): List<Int> {
        val ans = arrayListOf<Int>()
        nums.sortDescending()
        var cur = 0
        val sum = nums.sum().toDouble() / 2
        for (i in nums.indices) {
            if (cur > sum) {
                return ans
            }
            cur += nums[i]
            ans.add(nums[i])
        }
        return ans
    }
}