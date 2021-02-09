package leetcode.contest.last.b18

import leetcode.contest.utils.print
import kotlin.math.abs

fun main(args: Array<String>) {
    val s = Solution5154()
    s.maxValueAfterReverse(intArrayOf(2, 4, 9, 24, 2, 1, 10)).print()
}

class Solution5154 {
    fun maxValueAfterReverse(nums: IntArray): Int {
        val n = nums.size
        var sum = 0
        var gain = 0
        var hi = Int.MIN_VALUE
        var lo = Int.MAX_VALUE
        for (i in 0 until n - 1) {
            val n1 = nums[i]
            val n2 = nums[i + 1]
            sum += abs(n1 - n2)
            gain = maxOf(
                    gain,
                    abs(nums[0] - n2) - abs(n1 - n2),
                    abs(nums[n - 1] - n1) - abs(n1 - n2)
            )
            hi = maxOf(hi, minOf(n1, n2))
            lo = minOf(lo, maxOf(n1, n2))
        }
        return sum + maxOf(gain, (hi - lo) * 2)
    }
}