package leetcode.contest.cur.leetcode.c235

class Solution5722 {
    fun truncateSentence(s: String, k: Int): String {
        return s.split(" ").take(k).joinToString(" ")
    }
}