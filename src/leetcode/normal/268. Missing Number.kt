package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val source = arrayListOf(9, 6, 4, 2, 3, 5, 7, 0, 1).toIntArray()
    missingNumber(source).print()
}

fun missingNumber(nums: IntArray): Int {
    val count = nums.size
    val sum = nums.sum()

    return (1 + count) * count / 2 - sum
}