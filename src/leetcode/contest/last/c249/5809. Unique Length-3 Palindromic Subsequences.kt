package leetcode.contest.last.c249

class Solution5809 {
    fun countPalindromicSubsequence(s: String): Int {
        var ans = 0
        for (i in 'a'..'z') {
            var c = 0
            var start = false
            val cur = BooleanArray(26)
            s.forEach {
                if (it == i) {
                    if (!start) {
                        start = true
                    } else {
                        c = cur.count { it }
                        cur[it - 'a'] = true
                    }
                } else {
                    if (start) cur[it - 'a'] = true
                }
            }
            ans += c
        }
        return ans
    }
}