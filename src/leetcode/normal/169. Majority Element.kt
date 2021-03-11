package leetcode.normal

class Solution169 {
    fun majorityElement(nums: IntArray): Int {
        var count = 0
        var ans = -1
        for (num in nums) {
            if (count == 0) {
                ans = num
            }
            count += if (num == ans) 1 else -1
        }
        return ans
    }
}