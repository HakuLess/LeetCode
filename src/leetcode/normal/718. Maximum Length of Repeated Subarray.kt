package leetcode.normal

class Solution718 {
    fun findLength(A: IntArray, B: IntArray): Int {
        val dp = Array(A.size) { IntArray(B.size) }
        var max = 0
        for (i in A.indices) {
            for (j in B.indices) {
                if (A[i] == B[j]) {
                    if (i > 0 && j > 0) {
                        dp[i][j] = dp[i - 1][j - 1] + 1
                    } else {
                        dp[i][j] = 1
                    }
                    max = maxOf(max, dp[i][j])
                }
            }
        }
        return max
    }
}