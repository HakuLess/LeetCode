package leetcode.contest.utils

/**
 * Longest Common SubSequence
 * */
fun <T> lcs(v1: List<T>, v2: List<T>, m: Int, n: Int): Int {
    val dp = Array(m + 1) { IntArray(n + 1) }

    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
    for (i in 0..m) {
        for (j in 0..n) {
            if (i == 0 || j == 0)
                dp[i][j] = 0
            else if (v1[i - 1] == v2[j - 1])
                dp[i][j] = dp[i - 1][j - 1] + 1
            else
                dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
        }
    }
    return dp[m][n]
}