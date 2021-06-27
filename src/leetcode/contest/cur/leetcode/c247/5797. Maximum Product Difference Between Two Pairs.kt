package leetcode.contest.cur.leetcode.c247

class Solution5797 {
    fun maxProductDifference(nums: IntArray): Int {
        nums.sort()
        return nums[nums.lastIndex] * nums[nums.lastIndex - 1] - nums[0] * nums[1]
    }
}