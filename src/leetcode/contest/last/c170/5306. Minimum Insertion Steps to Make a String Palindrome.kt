package leetcode.contest.last.c170

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5306()
    s.minInsertions("leetcode").print()
}

// todo not finish
class Solution5306 {
    fun minInsertions(s: String): Int {
        val seen = HashMap<String, Int>()
        if (s in seen) {
            return seen[s]!!
        }
        val start = 0
        val end = s.lastIndex
        while (start < end) {
            return if (s[start] == s[end]) {
                val res = minInsertions(s.substring(start + 1, end))
                seen[s] = res
                res
            } else {
                val res = 1 + minOf(minInsertions(s.substring(start + 1, end + 1)), minInsertions(s.substring(start, end)))
                seen[s] = res
                res
            }
        }
        return 0
    }
}