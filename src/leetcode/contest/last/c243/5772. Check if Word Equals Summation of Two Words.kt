package leetcode.contest.last.c243

class Solution5772 {
    fun isSumEqual(firstWord: String, secondWord: String, targetWord: String): Boolean {
        val a = firstWord.map { it - 'a' }.joinToString("").toInt()
        val b = secondWord.map { it - 'a' }.joinToString("").toInt()
        val c = targetWord.map { it - 'a' }.joinToString("").toInt()
        return a + b == c
    }
}