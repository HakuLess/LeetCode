package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution209()
    s.minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)).print()
}

class Solution209 {
    fun minSubArrayLen(s: Int, nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var sum = nums[0]
        var left = 0
        var right = 0
        var ans = Integer.MAX_VALUE

        while (right <= nums.size) {
            println("$sum")
            if (sum < s) {
                right++
                sum += nums.getOrElse(right) { 0 }
            } else if (sum >= s) {
                if (right - left < ans) {
                    println("$right $left")
                    ans = right - left
                }
                sum -= nums[left]
                left++
            }
        }

        return if (ans == Integer.MAX_VALUE) {
            0
        } else {
            ans + 1
        }
    }
}