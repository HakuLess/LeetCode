package leetcode.contest.cur.c150

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5069()
    s.lastSubstring("aaa").print()
}

class Solution5069 {
    fun lastSubstring(s: String): String {
        var ch = 'a'
        s.forEach {
            if (it > ch) {
                ch = it
            }
        }

        if (s.all { it == ch }) {
            return s
        }

        var ans = ""
        s.forEachIndexed { index, c ->
            if (c == ch) {
                ans = maxOf(ans, s.substring(index))
            }
        }
        return ans
    }
}