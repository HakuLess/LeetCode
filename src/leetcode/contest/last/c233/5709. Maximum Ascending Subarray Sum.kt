package leetcode.contest.last.c233

class Solution5709 {
    fun maxAscendingSum(nums: IntArray): Int {
        var ans = nums[0]
        var cur = nums[0]
        for (i in 1 until nums.size) {
            if (nums[i] > nums[i - 1]) {
                cur += nums[i]
            } else {
                cur = nums[i]
            }
            ans = maxOf(ans, cur)
        }
        return ans
    }
}