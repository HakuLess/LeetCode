package leetcode.contest.cur.c158

class Solution5222 {
    fun balancedStringSplit(s: String): Int {
        var l = 0
        var r = 0
        var ans = 0
        s.forEach {
            if (it == 'L') {
                l++
            }
            if (it == 'R') {
                r++
            }
            if (l == r) {
                ans++
                l = 0
                r = 0
            }
        }
        return ans
    }
}