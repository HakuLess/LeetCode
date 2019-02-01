package leetcode

import kotlin.math.max

fun rob3(nums: IntArray): Int {
    return when {
        nums.isEmpty() -> 0
        nums.size == 1 -> nums[0]
        nums.size == 2 -> max(nums[0], nums[1])
        else -> {
            val robs = IntArray(nums.size)
            robs[0] = nums[0]
            robs[1] = max(nums[0], nums[1])

            for (i in 2 until nums.size) {
                robs[i] = max(robs[i - 2] + nums[i], robs[i - 1])
            }

            max(robs[robs.size - 1], robs[robs.size - 2])
        }
    }

}