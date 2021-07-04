package leetcode.contest.cur.leetcode.c248

class Solution5800 {
    fun buildArray(nums: IntArray): IntArray {
        val ans = IntArray(nums.size)
        for (i in nums.indices) {
            ans[i] = nums[nums[i]]
        }
        return ans
    }
}