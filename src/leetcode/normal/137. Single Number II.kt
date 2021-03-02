package leetcode.normal

class Solution137 {
    fun singleNumber(nums: IntArray): Int {
        val count = IntArray(32)
        var result = 0
        for (i in 0..31) {
            for (j in nums.indices) {
                count[i] += nums[j] shr i and 1
            }
            count[i] = count[i] % 3
            result = result or (count[i] shl i)
        }
        return result
    }
}