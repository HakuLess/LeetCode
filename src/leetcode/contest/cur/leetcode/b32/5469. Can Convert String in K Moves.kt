package leetcode.contest.cur.leetcode.b32

class Solution5469 {
    fun canConvertString(s: String, t: String, k: Int): Boolean {
        if (s.length != t.length) return false
        val seen = IntArray(26)
        for (i in s.indices) {
            if (s[i] == t[i]) continue
            else {
                var cur = t[i] - s[i]
                if (cur < 0) cur += 26
                seen[cur]++
                if ((seen[cur] - 1) * 26 + cur > k) {
                    return false
                }
            }
        }
        return true
    }
}