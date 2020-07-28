package leetcode.normal

class Solution338 {
    fun countBits(num: Int): IntArray {
        val dp = IntArray(num + 1)
        for (i in 1..num) {
            if (dp[i] == 0) {
                dp[i] = dp[i - 1] + 1
            }
            var c = i * 2
            while (c <= num) {
                dp[c] = dp[i]
                c *= 2
            }
        }
        return dp
    }
}