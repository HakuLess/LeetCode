package leetcode.normal

class Solution643 {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var sum = 0
        for (i in 0 until k) {
            sum += nums[i]
        }
        var max = sum
        for (i in k until nums.size) {
            sum -= nums[i - k]
            sum += nums[i]
            max = maxOf(sum, max)
        }
        return max.toDouble() / k
    }
}