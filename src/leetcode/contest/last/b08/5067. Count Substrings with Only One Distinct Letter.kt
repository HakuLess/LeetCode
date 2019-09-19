package leetcode.contest.last.b08

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5067()
    s.countLetters("aaaba").print()
    s.countLetters("aaaaaaaaaa").print()
}

class Solution5067 {
    fun countLetters(S: String): Int {
        if (S.isEmpty()) {
            return 0
        }
        var a = S[0]
        var ans = 1
        var cur = 1
        for (i in 1 until S.length) {
            if (S[i] == a) {
                cur++
            } else {
                cur = 1
                a = S[i]
            }
            ans += cur
        }
        return ans
    }
}