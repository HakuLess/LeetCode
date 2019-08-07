package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution10()
    s.isMatch("aa", "a").print()
    s.isMatch("aa", "a*").print()
    s.isMatch("ab", ".*").print()
    s.isMatch("aab", "c*a*b").print()
    s.isMatch("mississippi", "mis*is*p*.").print()
}

class Solution10 {

    fun isMatch(s: String, p: String): Boolean {
        if (p.isEmpty()) {
            return s.isEmpty()
        }
        val match = s.isNotEmpty() && (p[0] == s[0] || p[0] == '.')

        return if (p.length >= 2 && p[1] == '*') {
            isMatch(s, p.substring(2)) || match && isMatch(s.substring(1), p)
        } else {
            match && isMatch(s.substring(1), p.substring(1))
        }
    }
}