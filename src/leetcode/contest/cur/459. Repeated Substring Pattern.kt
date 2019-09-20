package leetcode.contest.cur

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution459()
    s.repeatedSubstringPattern("abab").print()
    s.repeatedSubstringPattern("aba").print()
    s.repeatedSubstringPattern("abcabcabcabc").print()
}

class Solution459 {
    fun repeatedSubstringPattern(s: String): Boolean {
        var str = s.plus(s)
        str = str.drop(1)
        str = str.dropLast(1)
        return str.contains(s)
    }
}