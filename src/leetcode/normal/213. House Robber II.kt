package leetcode.normal

import leetcode.print
import kotlin.math.max

fun main(args: Array<String>) {
    val array = intArrayOf(1, 2, 3, 1)
    rob(array).print()
}

fun rob(nums: IntArray): Int {
    return when {
        nums.isEmpty() -> 0
        nums.size == 1 -> nums[0]
        nums.size == 2 -> max(nums[0], nums[1])
        else -> {
            max(robHelp(nums.copyOfRange(0, nums.size - 1)), robHelp(nums.copyOfRange(1, nums.size)))
        }
    }
}

fun robHelp(nums: IntArray): Int {
    val robs = IntArray(nums.size)
    robs[0] = nums[0]
    robs[1] = max(nums[0], nums[1])

    for (i in 2 until nums.size) {
        robs[i] = max(robs[i - 2] + nums[i], robs[i - 1])
    }

    return max(robs[robs.size - 1], robs[robs.size - 2])
}