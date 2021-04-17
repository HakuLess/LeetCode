package leetcode.contest.cur.leetcode.b50

class Solution5717 {
    fun minOperations(nums: IntArray): Int {
        var ans = 0
        for (i in 1 until nums.size) {
            if (nums[i] <= nums[i - 1]) {
                ans += nums[i - 1] + 1 - nums[i]
                nums[i] = nums[i - 1] + 1
            }
        }
        return ans
    }
}