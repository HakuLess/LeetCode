package leetcode.contest.cur.c195

import leetcode.contest.utils.print
import kotlin.math.pow


fun main(args: Array<String>) {
    val s = Solution5450()
//    s.numSubseq(intArrayOf(3, 5, 6, 7), 9).print()
//    s.numSubseq(intArrayOf(3, 3, 6, 8), 10).print()
//    s.numSubseq(intArrayOf(2, 3, 3, 4, 6, 7), 12).print()

    s.numSubseq(intArrayOf(7, 10, 7, 3, 7, 5, 4), 12).print()
}

class Solution5450 {
    fun numSubseq(nums: IntArray, target: Int): Int {
        nums.sort()
        val mod = 1000000007L
        fun bis(l: Int, r: Int, t: Int): Int {
            var left = l
            var right = r
            while (left + 1 < right) {
                val mid = (left + right).ushr(1)
                when {
                    (nums[mid] > t) -> right = mid
                    else -> left = mid
                }
            }
            if (nums[left] > t) {
                return -1
            }
            return if (nums[right] <= t) {
                right
            } else {
                left
            }
        }

        val pw = LongArray(1000100) { 1L }
        for (i in 1..1000000) pw[i] = pw[i - 1] * 2 % mod

        var ans = 0L
        for (i in 0..nums.lastIndex) {
            val index = bis(i, nums.lastIndex, target - nums[i])
            if (index == -1) continue
            val tmp = pw[index - i]
            ans = (ans + tmp % mod) % mod
        }
        return (ans % mod).toInt()
    }
}