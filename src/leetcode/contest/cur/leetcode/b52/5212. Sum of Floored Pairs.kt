package leetcode.contest.cur.leetcode.b52

import kotlin.math.abs

// todo not finish
class Solution5212 {
    fun sumOfFlooredPairs(nums: IntArray): Int {
        val mod = 1000000007L
        val m = 2e5.toInt()
        val n = nums.size
        val freq = LongArray(m)
        val preFreq = LongArray(m)
        for (i in 0 until n) {
            freq[nums[i]]++
        }
        for (i in 1 until m) {
            preFreq[i] = preFreq[i - 1] + freq[i]
        }
        var ans = 0L
        for (i in 1 until m) {
            var j = i
            while (j < m) {
                val x = (preFreq[j - 1] - preFreq[abs(j - i - 1)])
                ans += x * (j / i - 1) * freq[i]
                ans %= mod
                j += i
            }
        }
        return (ans % mod).toInt()
    }
}
