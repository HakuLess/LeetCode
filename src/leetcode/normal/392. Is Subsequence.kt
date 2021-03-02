package leetcode.normal

class Solution392 {
    fun isSubsequence(s: String, t: String): Boolean {
        var x = 0
        var y = 0
        while (x < s.length && y < t.length) {
            if (s[x] == t[y]) {
                x++
                y++
            } else {
                y++
            }
        }
        return x == s.length
    }
}