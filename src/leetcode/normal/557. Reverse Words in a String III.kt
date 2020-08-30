package leetcode.normal

class Solution557 {
    fun reverseWords(s: String): String {
        val ans = arrayListOf<String>()
        s.split(" ").forEach {
            ans.add(it.reversed())
        }
        return ans.joinToString(" ")
    }
}