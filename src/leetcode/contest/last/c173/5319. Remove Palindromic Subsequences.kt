package leetcode.contest.last.c173

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5319()
    s.removePalindromeSub("ababa").print()
    s.removePalindromeSub("abb").print()
    s.removePalindromeSub("baabb").print()
    s.removePalindromeSub("abbaaaab").print()
}

class Solution5319 {
    fun removePalindromeSub(s: String): Int {
        if (s.isEmpty()) {
            return 0
        }
        val c = s.toCharArray()
        var l = 0
        var r = c.lastIndex
        while (l <= r) {
            if (c[l] == c[r]) {
                l++
                r--
            } else {
                return 2
            }
        }
        return 1
    }
}