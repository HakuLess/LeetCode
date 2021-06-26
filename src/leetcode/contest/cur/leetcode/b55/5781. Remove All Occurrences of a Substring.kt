package leetcode.contest.cur.leetcode.b55

import leetcode.contest.utils.print
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val s = Solution5781()
    s.removeOccurrences("daabcbaabcbc", "abc").print()
}

class Solution5781 {
    fun removeOccurrences(s: String, part: String): String {
        var cur = s
        while (cur.indexOf(part) != -1) {
            val index = cur.indexOf(part)
            cur = cur.removeRange(IntRange(index, index + part.length - 1))
        }
        return cur
    }
}