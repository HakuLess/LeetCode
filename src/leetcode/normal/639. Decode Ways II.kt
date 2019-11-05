package leetcode.normal

import leetcode.contest.utils.print


fun main(args: Array<String>) {
    val s = Solution639()
    s.numDecodings("*").print()
    s.numDecodings("1*").print()
    s.numDecodings("1**").print()
    s.numDecodings("**********1111111111").print()
}

class Solution639 {
    val mod = 1000000007
    fun numDecodings(s: String): Int {
        val dp = LongArray(s.length + 1)
        dp[0] = 1
        dp[1] = if (s[0] == '*') 9 else 1
        if (s[0] == '0')
            return 0

        for (i in 1 until s.length) {
            var multi = 1
            if (s[i - 1] == '*' && s[i] == '*') multi = 15
            if (s[i - 1] == '*' && s[i] in '7'..'9') multi = 1
            if (s[i - 1] == '*' && s[i] in '0'..'6') multi = 2
            if (s[i - 1] in '3'..'9') multi = 0
            if (s[i - 1] in '1'..'1' && s[i] == '*') multi = 9
            if (s[i - 1] == '2' && s[i] == '*') multi = 6
            if (s[i - 1] in '0'..'1' && s[i] != '*') multi = 1
            if (s[i - 1] == '2' && s[i] in '7'..'9') multi = 0
            if (s[i - 1] == '0') multi = 0

            val single = when {
                s[i] == '*' -> 9
                s[i] == '0' -> 0
                else -> 1
            }
            dp[i + 1] = (dp[i] * single + dp[i - 1] * multi) % mod
        }

        return (dp.last() % mod).toInt()
    }
}