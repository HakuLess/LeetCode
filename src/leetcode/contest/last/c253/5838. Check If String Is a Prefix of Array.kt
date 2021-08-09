package leetcode.contest.last.c253

class Solution5838 {
    fun isPrefixString(s: String, words: Array<String>): Boolean {
        return (1..words.size).any {
            words.take(it).joinToString("") == s
        }
    }
}