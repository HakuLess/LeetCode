package leetcode.normal

import leetcode.contest.utils.print
import java.util.*


fun main(args: Array<String>) {
    containsNearbyAlmostDuplicate(
            intArrayOf(1, 6), 2, 3).print()
}

fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
    if (nums.isEmpty() || k <= 0) {
        return false
    }

    val values = TreeSet<Long>()
    for (ind in nums.indices) {
        val floor = values.floor(nums[ind].toLong() + t)
        val ceil = values.ceiling(nums[ind].toLong() - t)
        if (floor != null && floor >= nums[ind] || ceil != null && ceil <= nums[ind]) {
            return true
        }
        values.add(nums[ind].toLong())
        if (ind >= k) {
            values.remove((nums[ind - k]).toLong())
        }
    }

    return false
}