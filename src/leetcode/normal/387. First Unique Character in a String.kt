package leetcode.normal

class Solution387 {
    fun firstUniqChar(s: String): Int {
        val ans = IntArray(26) { -1 }
        for (c in s.indices) {
            if (ans[s[c] - 'a'] == -1) {
                ans[s[c] - 'a'] = c
            } else {
                ans[s[c] - 'a'] = -2
            }
        }
        if (ans.all { it < 0 }) return -1
        return ans.filter { it >= 0 }.min()!!
    }
}