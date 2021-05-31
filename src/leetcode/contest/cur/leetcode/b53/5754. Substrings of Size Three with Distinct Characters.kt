package leetcode.contest.cur.leetcode.b53

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5754()
    s.countGoodSubstrings("xyzzaz").print()
    s.countGoodSubstrings("aababcabc").print()
}

class Solution5754 {
    fun countGoodSubstrings(s: String): Int {
        var ans = 0
        for (i in 0 until s.length - 2) {
            if (s[i] != s[i + 1] && s[i + 1] != s[i + 2] && s[i] != s[i + 2])
                ans++
        }
        return ans
    }
}