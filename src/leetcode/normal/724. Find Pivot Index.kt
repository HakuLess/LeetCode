package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution724()
    s.pivotIndex(intArrayOf(1, 7, 3, 6, 5, 6)).print()
}

class Solution724 {
    fun pivotIndex(nums: IntArray): Int {
        val n = nums.size
        val left = IntArray(n + 1)
        val right = IntArray(n + 1)
        for (i in nums.indices) {
            left[i + 1] = nums[i] + left[i]
        }
        for (i in nums.indices.reversed()) {
            right[i] = nums[i] + right[i + 1]
        }
        for (i in 0 until left.lastIndex) {
            if (left[i] == right[i + 1]) {
                return i
            }
        }
        return -1
    }
}