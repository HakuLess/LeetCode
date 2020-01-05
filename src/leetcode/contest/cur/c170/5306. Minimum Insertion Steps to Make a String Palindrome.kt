package leetcode.contest.cur.c170

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5306()
    s.minInsertions("leetcode").print()
}

class Solution5306 {
    val seen = HashMap<String, Int>()
    fun minInsertions(s: String): Int {
        if (s in seen) {
            return seen[s]!!
        }
        var start = 0
        var end = s.lastIndex
        var ans = 0
        while (start < end) {
            if (s[start] == s[end]) {
                val res = minInsertions(s.substring(start + 1, end))
                seen[s] = res
                return res
            } else {
                val res = 1 + minOf(minInsertions(s.substring(start + 1, end + 1)), minInsertions(s.substring(start, end)))
                seen[s] = res
                return res
            }
        }
        return 0
    }
}