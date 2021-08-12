package leetcode.normal

class Solution213 {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        val robs = IntArray(nums.size)
        robs[0] = nums[0]
        robs[1] = maxOf(nums[0], nums[1])
        for (i in 2 until nums.lastIndex) {
            robs[i] = maxOf(robs[i - 2] + nums[i], robs[i - 1])
        }
        val a = robs.maxOrNull()!!
        robs[0] = 0
        robs[1] = nums[1]
        for (i in 2..nums.lastIndex) {
            robs[i] = maxOf(robs[i - 2] + nums[i], robs[i - 1])
        }
        val b = robs.maxOrNull()!!
        return maxOf(a, b)
    }
}