package leetcode.contest.cur.leetcode.c204

class Solution5500 {
    fun getMaxLen(nums: IntArray): Int {
        var ans = 0
        var pos = 0
        var neg = 0
        for (num in nums) {
            if (num == 0) {
                neg = 0
                pos = 0
            } else if (num > 0) {
                ++pos
                if (neg > 0) {
                    ++neg
                }
            } else {
                val np = if (neg > 0) neg + 1 else 0
                val ng = pos + 1
                pos = np
                neg = ng
            }
            ans = maxOf(ans, pos)
        }
        return ans
    }
}