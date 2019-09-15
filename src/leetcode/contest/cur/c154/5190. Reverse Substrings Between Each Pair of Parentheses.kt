package leetcode.contest.cur.c154

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5190()
    s.reverseParentheses("(ed(et(oc))el)").print()
    s.reverseParentheses("ta()usw((((a))))").print()
}

class Solution5190 {
    fun reverseParentheses(s: String): String {
        if (s.all { it != '(' }) {
            return s
        }
        var l = 0
        var r = 0
        s.forEachIndexed { index, it ->
            when (it) {
                '(' -> {
                    l = index
                }
                ')' -> {
                    r = index
                    return reverse(s, l, r)
                }
            }
        }
        return ""
    }

    private fun reverse(s: String, l: Int, r: Int): String {
        val next = s.substring(IntRange(0, l - 1)) + s.substring(IntRange(l + 1, r - 1)).reversed() + s.substring(IntRange(r + 1, s.lastIndex))
//        next.print()
        return reverseParentheses(next)
    }
}