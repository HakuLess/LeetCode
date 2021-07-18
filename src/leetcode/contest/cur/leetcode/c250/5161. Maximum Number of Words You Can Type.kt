package leetcode.contest.cur.leetcode.c250

class Solution5161 {
    fun canBeTypedWords(text: String, brokenLetters: String): Int {
        return text.split(" ").count {
            it.all { it !in brokenLetters }
        }
    }
}