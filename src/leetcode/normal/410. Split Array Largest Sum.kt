package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    splitArray(intArrayOf(7, 2, 5, 10, 8), 2).print()
}

fun splitArray(nums: IntArray, m: Int): Int {
    var left = nums.max()!!
    var right = nums.sum()

    while (left < right) {
        val mid = left + (right - left) / 2
        when {
            checkSum(mid, nums, m) -> right = mid
            else -> left = mid + 1
        }
    }

    return left
}

fun checkSum(sum: Int, nums: IntArray, m: Int): Boolean {
    var times = 0
    var temp = 0
    nums.forEach {
        temp += it
        if (temp > sum) {
            times++
            temp = it
        }
    }
    times++

    return times <= m
}