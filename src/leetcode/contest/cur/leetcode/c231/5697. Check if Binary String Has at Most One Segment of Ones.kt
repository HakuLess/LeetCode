package leetcode.contest.cur.leetcode.c231

class Solution5697 {
    fun checkOnesSegment(s: String): Boolean {
        var zero = false
        var one = false
        for (i in s.indices) {
            if (s[i] == '1') {
                one = true
                if (one && zero) {
                    return false
                }
            } else {
                if (one)
                    zero = true
            }
        }
        return true
    }
}