package leetcode.contest.cur.leetcode.c241

class Solution5759 {
    fun subsetXORSum(nums: IntArray): Int {
        var bits = 0
        val n = nums.size
        for (i in 0 until n) bits = bits or nums[i]
        return bits * Math.pow(2.0, n - 1.toDouble()).toInt()
    }
}
