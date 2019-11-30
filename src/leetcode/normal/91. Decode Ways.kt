package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution91()
    s.numDecodings("226").print()
    s.numDecodings("12").print()
    s.numDecodings("10").print()
    s.numDecodings("10000").print()
}

class Solution91 {
    fun numDecodings(s: String): Int {
        if (s.startsWith('0')) {
            return 0
        }
        val dp = IntArray(s.length)
        dp[0] = 1
        for (i in 1..s.lastIndex) {
            if (s[i] != '0') {
                dp[i] += dp[i - 1]
            }
            if ((s[i - 1] + s[i].toString()).toInt() in 10..26) {
                dp[i] += dp.getOrElse(i - 2) { 1 }
            }
        }
        dp.print()
        return dp.last()
    }
}