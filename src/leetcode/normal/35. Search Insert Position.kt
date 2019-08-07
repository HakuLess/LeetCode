package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    searchInsert(intArrayOf(1, 3), 3).print()
}

fun searchInsert(nums: IntArray, target: Int): Int {

    var start = 0
    var end = nums.size

    if (target <= nums[0]) {
        return 0
    }

    if (target > nums[end - 1]) {
        return end
    }

    while (start < end - 1) {
        when {
            nums[(start + end) / 2] > target -> end = (start + end) / 2
            nums[(start + end) / 2] == target -> return (start + end) / 2
            else -> start = (start + end) / 2
        }
    }

    return end
}