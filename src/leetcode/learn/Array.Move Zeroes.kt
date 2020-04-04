package leetcode.learn

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val intArray = intArrayOf(0, 1, 0, 3, 12)
    moveZeroes(intArray)
}

private fun moveZeroes(nums: IntArray): Unit {

    var offset = 0
    nums.forEachIndexed { index, value ->
        if (value == 0) {
            offset++
        } else if (offset != 0) {
            nums[index - offset] = nums[index]
            nums[index] = 0
        }
    }

    nums.print()
}