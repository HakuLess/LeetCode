package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    containsNearbyDuplicate(intArrayOf(1, 2, 3, 1, 2, 3), 2).print()
}

fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val set = mutableSetOf<Int>()
    for (i in nums.indices) {
        if (i > k) {
            set.remove(nums[i - k - 1])
        }
        if (!set.add(nums[i])) {
            return true
        }
    }
    return false
}