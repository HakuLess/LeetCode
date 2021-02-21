package leetcode.contest.cur.leetcode.c229

class Solution5685 {
    fun mergeAlternately(word1: String, word2: String): String {
        var str = ""
        for (i in 0 until maxOf(word1.length, word2.length)) {
            if (i in word1.indices) {
                str += word1[i]
            }
            if (i in word2.indices) {
                str += word2[i]
            }
        }
        return str
    }
}