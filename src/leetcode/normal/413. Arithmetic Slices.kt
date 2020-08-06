package leetcode.normal

class Solution413 {
    fun numberOfArithmeticSlices(A: IntArray): Int {
        if (A.size < 3) {
            return 0
        }
        val dp = IntArray(A.size)
        dp[0] = 0
        dp[1] = 0
        for (i in 2 until A.size) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1
            } else {
                dp[i] = 0
            }
        }
        return dp.sum()
    }
}