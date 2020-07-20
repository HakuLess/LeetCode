package leetcode.normal

class Solution97 {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        val n = s1.length
        val m = s2.length
        val l = s3.length
        if (n + m != l) return false

        val dp = Array<BooleanArray>(n + 1) { BooleanArray(m + 1) { false } }
        dp[0][0] = true
        for (i in 0..n) {
            for (j in 0..m) {
                val p = i + j - 1
                if (i > 0)
                    dp[i][j] = dp[i][j] or (dp[i - 1][j] && s1[i - 1] == s3[p])
                if (j > 0)
                    dp[i][j] = dp[i][j] or (dp[i][j - 1] && s2[j - 1] == s3[p])
            }
        }
        return dp[n][m]
    }
//    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
//        if (s3.length != s1.length + s2.length) return false
//        if (s1.isEmpty()) return s2 == s3
//        if (s2.isEmpty()) return s1 == s3
//        return if (s3[0] == s1[0] && s3[0] == s2[0]) {
//            (isInterleave(s1.substring(1, s1.length), s2, s3.substring(1, s3.length))
//                    || isInterleave(s1, s2.substring(1, s2.length), s3.substring(1, s3.length)))
//        } else if (s3[0] == s1[0]) {
//            isInterleave(s1.substring(1, s1.length), s2, s3.substring(1, s3.length))
//        } else if (s3[0] == s2[0]) {
//            isInterleave(s1, s2.substring(1, s2.length), s3.substring(1, s3.length))
//        } else {
//            false
//        }
//    }
}