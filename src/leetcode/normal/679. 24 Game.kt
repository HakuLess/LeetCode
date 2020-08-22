package leetcode.normal

import kotlin.math.abs

class Solution679 {

    fun judgePoint24(nums: IntArray): Boolean {
        return backTrack(nums, 0)
    }

    private fun backTrack(nums: IntArray, index: Int): Boolean {
        if (index == 4) {
            return judge(nums[0].toDouble(), nums[1].toDouble(), nums[2].toDouble(), nums[3].toDouble())
        }
        for (i in index..3) {
            swap(nums, index, i)
            if (backTrack(nums, index + 1)) return true
            swap(nums, index, i)
        }
        return false
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val tmp = nums[i]
        nums[i] = nums[j]
        nums[j] = tmp
    }

    private fun judge(a: Double, b: Double, c: Double, d: Double): Boolean {
        return judge(a + b, c, d) ||
                judge(a - b, c, d) ||
                judge(a * b, c, d) ||
                judge(a / b, c, d)
    }

    private fun judge(a: Double, b: Double, c: Double): Boolean {
        return judge(a + b, c) ||
                judge(a - b, c) ||
                judge(a * b, c) ||
                judge(a / b, c) ||
                judge(b - a, c) ||
                judge(b / a, c) ||
                judge(a, b - c) ||
                judge(a, b + c) ||
                judge(a, b * c) ||
                judge(a, b / c)
    }

    private fun judge(a: Double, b: Double): Boolean {
        return abs(a + b - 24) < 0.001 || abs(a - b - 24) < 0.001
                || abs(a * b - 24) < 0.001 || abs(a / b - 24) < 0.001
                || abs(b - a - 24) < 0.001 || abs(b / a - 24) < 0.001
    }
}