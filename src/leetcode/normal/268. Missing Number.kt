package leetcode.normal

class Solution268 {
    fun missingNumber(nums: IntArray): Int {
        val count = nums.size
        val sum = nums.sum()
        return (1 + count) * count / 2 - sum
    }
}