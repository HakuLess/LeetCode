package leetcode.contest.last.b26

class Solution5396 {
    fun maxPower(s: String): Int {
        var ans = 0
        var last = ' '
        var cur = 0
        for (i in s.indices) {
            if (s[i] == last) {
                cur++
            } else {
                cur = 1
                last = s[i]
            }
            ans = maxOf(ans, cur)
        }
        return ans
    }
}