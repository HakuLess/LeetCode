package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution410()
    s.splitArray(intArrayOf(7, 2, 5, 10, 8), 2).print()
}

class Solution410 {
    fun splitArray(nums: IntArray, m: Int): Int {
        fun checkSum(sum: Int, nums: IntArray): Boolean {
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

        var left = nums.max()!!
        var right = nums.sum()
        while (left < right) {
            val mid = left + (right - left) / 2
            when {
                checkSum(mid, nums) -> right = mid
                else -> left = mid + 1
            }
        }
        return left
    }
}

