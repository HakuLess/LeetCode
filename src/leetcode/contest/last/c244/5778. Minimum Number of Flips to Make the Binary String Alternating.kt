package leetcode.contest.last.c244

class Solution5778 {
    fun minFlips(s: String): Int {
        val n = s.length
        val t = s + s
        var a0 = 0
        var a1 = 0
        var b0 = 0
        var b1 = 0
        var ans = Int.MAX_VALUE
        for (i in t.indices) {
            if (t[i] == '0') if (i % 2 == 0) a0++ else b0++
            else if (i % 2 == 0) a1++ else b1++

            if (i >= n) {
                if (t[i - n] == '0') if ((i - n) % 2 == 0) a0-- else b0--
                else if ((i - n) % 2 == 0) a1-- else b1--
            }
            ans = minOf(ans, minOf(n - a0 - b1, n - a1 - b0))
        }
        return ans
    }
}