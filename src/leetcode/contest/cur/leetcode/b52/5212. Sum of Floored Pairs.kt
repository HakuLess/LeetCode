package leetcode.contest.cur.leetcode.b52

import kotlin.math.abs

class Solution5212 {
    fun sumOfFlooredPairs(nums: IntArray): Int {
        val mod = 1000000007L
        return (GFG.getFloorSum(nums, nums.size) % mod).toInt()
    }
}

internal object GFG {
    var m = 3e5.toInt()
    fun getFloorSum(arr: IntArray, n: Int): Long {
        val freq = IntArray(m)
        val preFreq = IntArray(m)
        for (i in 0 until n) {
            freq[arr[i]]++
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
                j += i
            }
        }
        return ans
    }
}
