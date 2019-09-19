package leetcode.normal

import leetcode.contest.utils.lcs

class Solution1143 {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        return lcs(text1.toList(), text2.toList(), text1.length, text2.length)
    }
}