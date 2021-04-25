package leetcode.contest.cur.leetcode.c238

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5739()
    s.maxFrequency(intArrayOf(1, 2, 4), 5).print()
}

class Solution5739 {
    fun maxFrequency(nums: IntArray, k: Int): Int {
        nums.sort()
        val preSum = IntArray(nums.size + 1)
        for (i in nums.indices) {
            preSum[i + 1] = preSum[i] + nums[i]
        }
        preSum.print()
        var ans = 0
        var i = 0
        for (j in nums.indices) {
            while (nums[j] * (j - i + 1) - (preSum[j + 1] - preSum[i]) > k) {
                println("$j, $i : ${nums[j] * (j - i + 1) - (preSum[j + 1] - preSum[i])}")
                i++
            }
            println("$j, $i : ${nums[j] * (j - i + 1) - (preSum[j + 1] - preSum[i])}")
            ans = maxOf(ans, j - i + 1)
        }
        return ans
    }
}