package leetcode.normal

class Solution198 {
    fun rob(nums: IntArray): Int {
        return when {
            nums.isEmpty() -> 0
            nums.size == 1 -> nums[0]
            nums.size == 2 -> maxOf(nums[0], nums[1])
            else -> {
                val robs = IntArray(nums.size)
                robs[0] = nums[0]
                robs[1] = maxOf(nums[0], nums[1])
                for (i in 2 until nums.size) {
                    robs[i] = maxOf(robs[i - 2] + nums[i], robs[i - 1])
                }
                maxOf(robs[robs.size - 1], robs[robs.size - 2])
            }
        }
    }
}