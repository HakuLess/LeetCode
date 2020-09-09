package leetcode.normal

class Solution151 {
    fun reverseWords(s: String): String {
        return s.trim().split(' ').reversed().filter {
            it.isNotBlank()
        }.joinToString(" ")
    }
}