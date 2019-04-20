package leetcode.learn

import leetcode.print

fun main(args: Array<String>) {
    val intArray = intArrayOf(7, 1, 5, 3, 6, 4, 1)
    containsDuplicate(intArray).print()
}

fun containsDuplicate(nums: IntArray): Boolean {
    return nums.distinct().size != nums.size
}