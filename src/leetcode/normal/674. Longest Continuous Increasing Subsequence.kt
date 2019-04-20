package leetcode.normal

class Solution674 {
    fun findLengthOfLCIS(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var start = 0
        var max = 1
        for (i in 1 until nums.size) {
            if (nums[i] > nums[i - 1]) {
                max = maxOf(i - start + 1, max)
            } else {
                start = i
            }
        }
        return max
    }
}