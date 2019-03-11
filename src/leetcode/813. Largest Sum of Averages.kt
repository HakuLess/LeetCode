package leetcode

// todo study
class Solution813 {

    fun largestSumOfAverages(A: IntArray, K: Int): Double {
        val n = A.size
        val sum = DoubleArray(n + 1)
        for (i in 0 until n) {
            sum[i + 1] = sum[i] + A[i]
        }

        val dp = DoubleArray(n)
        for (i in 0 until n) {
            dp[i] = (sum[n] - sum[i]) / (n - i)
        }

        for (k in 0 until K - 1) {
            for (i in 0 until n) {
                for (j in i + 1 until n) {
                    dp[i] = maxOf(dp[i], (sum[j] - sum[i]) / (j - i) + dp[j])
                }
            }
        }
        return dp[0]
    }

}