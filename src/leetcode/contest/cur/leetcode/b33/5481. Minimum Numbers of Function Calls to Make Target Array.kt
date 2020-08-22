package leetcode.contest.cur.leetcode.b33

import leetcode.contest.utils.print
import kotlin.math.ln


fun main(args: Array<String>) {
    val s = Solution5481()
//    s.minOperations(intArrayOf(2, 4, 8, 16)).print()
    s.minOperations(intArrayOf(1000000000)).print()
}

class Solution5481 {
    fun minOperations(nums: IntArray): Int {
        var ans = 0
        val max = nums.max()!!
        val l = (ln(max.toDouble()) / ln(2.0)).toInt()
        nums.forEach {
            ans += Integer.bitCount(it)
        }
        return ans + l
    }
}