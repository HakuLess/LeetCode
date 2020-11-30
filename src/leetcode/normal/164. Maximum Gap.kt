package leetcode.normal

class Solution164 {
    fun maximumGap(nums: IntArray): Int {
        nums.sort()
        var ans = -1
        for (i in nums.indices) {
            if (i != 0) {
                ans = maxOf(ans, nums[i] - nums[i - 1])
            }
        }
        return ans
    }
}