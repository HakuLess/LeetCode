package leetcode.contest.cur.leetcode.b48

class Solution5693 {
    fun secondHighest(s: String): Int {
        var m = false
        for (i in '9' downTo '0') {
            if (i in s) {
                if (m) return i - '0'
                m = true
            }
        }
        return -1
    }
}