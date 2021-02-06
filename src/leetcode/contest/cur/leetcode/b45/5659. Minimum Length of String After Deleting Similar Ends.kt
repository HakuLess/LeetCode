package leetcode.contest.cur.leetcode.b45

class Solution5659 {
    fun minimumLength(s: String): Int {
        var i = 0
        var j = s.lastIndex
        var ans = s.length
        while (i < j) {
            if (s[i] != s[j]) break
            val c = s[i]
            while (i < s.length && s[i] == c) {
                i++
            }
            while (j >= 0 && s[j] == c) {
                j--
            }
        }
        return maxOf(j - i + 1, 0)
    }
}