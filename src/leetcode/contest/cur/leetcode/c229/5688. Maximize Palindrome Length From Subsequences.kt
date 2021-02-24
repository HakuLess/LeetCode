package leetcode.contest.cur.leetcode.c229

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5688()
    s.longestPalindrome("aa", "bb").print()
    s.longestPalindrome("ceebeddc", "d").print()
//    s.longestPalindrome("eeeecd", "eabfbeeb").print()
}

class Solution5688 {
    fun longestPalindrome(word1: String, word2: String): Int {
        val s = "$word1$word2"
        val dp = Array(s.length) { IntArray(s.length) }
        var ans = 0
        for (i in s.lastIndex downTo 0) {
            dp[i][i] = 1
            for (j in i + 1 until s.length) {
                if (s[i] == s[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2
                    if (i in word1.indices && j >= word1.length)
                        ans = maxOf(ans, dp[i][j])
                } else {
                    dp[i][j] = maxOf(dp[i + 1][j], dp[i][j - 1])
                }
            }
        }
        return ans
    }
}