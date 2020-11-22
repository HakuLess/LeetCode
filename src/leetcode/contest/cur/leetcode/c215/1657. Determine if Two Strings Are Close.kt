package leetcode.contest.cur.leetcode.c215

class Solution1657 {
    fun closeStrings(word1: String, word2: String): Boolean {
        val c1 = IntArray(26)
        word1.forEach {
            c1[it - 'a']++
        }
        val c2 = IntArray(26)
        word2.forEach {
            c2[it - 'a']++
        }
        for (i in c1.indices) {
            if (c1[i] == 0 && c2[i] != 0) return false
            if (c1[i] != 0 && c2[i] == 0) return false
        }
        return c1.sorted().joinToString(",") == c2.sorted().joinToString(",")
    }
}