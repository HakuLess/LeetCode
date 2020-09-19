package leetcode.contest.cur.leetcode.b35


class Solution5503 {
    fun sumOddLengthSubarrays(arr: IntArray): Int {
        val n = arr.size
        val dp = IntArray(n) { 1 }
        val res = IntArray(n) { 0 }
        res[0] = arr[0]
        for (i in 1..n) {
            res[i] += arr[i]
            if (i > 1) {
                dp[i] += dp[i - 1]
                res[i] += res[i - 2] + dp[i - 2] * (arr[i] + arr[i - 1])
            }
        }
        return res.sum()
    }
}