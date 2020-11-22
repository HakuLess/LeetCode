package leetcode.normal

class Solution242 {
    fun isAnagram(s: String, t: String): Boolean {
        return t.toCharArray().sorted().joinToString("") == s.toCharArray().sorted().joinToString("")
    }
}