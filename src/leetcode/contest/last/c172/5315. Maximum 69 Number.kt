package leetcode.contest.last.c172

class Solution5315 {
    fun maximum69Number (num: Int): Int {
        val s = num.toString()
        if (s.all { it == '9' }) {
            return num
        }
        var ans = ""
        var first = true
        for (i in s.indices) {
            if (s[i] == '6' && first) {
                ans += '9'
                first = false
            } else {
                ans += s[i]
            }
        }
        return ans.toInt()
    }
}