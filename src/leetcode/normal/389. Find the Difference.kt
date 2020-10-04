package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution389()
    s.findTheDifference("abcd", "abcde").toString().print()
}

class Solution389 {
    fun findTheDifference(s: String, t: String): Char {
        val c = IntArray(26)
        s.forEach {
            c[it - 'a']++
        }
        for (i in t.indices) {
            val it = t[i]
            c[it - 'a']--
            if (c[it - 'a'] == -1) return it
        }
        return ' '
    }
}