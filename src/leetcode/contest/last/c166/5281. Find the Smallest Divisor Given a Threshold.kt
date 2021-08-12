package leetcode.contest.last.c166

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5281()
    s.smallestDivisor(intArrayOf(1, 2, 5, 9), 6).print()
    s.smallestDivisor(intArrayOf(2, 3, 5, 7, 11), 11).print()
    s.smallestDivisor(intArrayOf(19), 5).print()

    s.smallestDivisor(intArrayOf(1, 2, 3), 6).print()
}

class Solution5281 {
    fun smallestDivisor(nums: IntArray, threshold: Int): Int {
        var left = 1
        var right = nums.maxOrNull()!!
        while (left + 1 < right) {
            val mid = (left + right).ushr(1)
            when {
                (check(nums, mid) <= threshold) -> right = mid
                else -> left = mid
            }
        }
        return if (check(nums, left) <= threshold) {
            left
        } else {
            right
        }
    }

    private fun check(nums: IntArray, key: Int): Int {
        var ans = 0
        nums.forEach {
            ans += it / key + if (it % key == 0) {
                0
            } else {
                1
            }
        }
        println("$key : $ans")
        return ans
    }
}