package leetcode.contest.cur.leetcode.c219

class Solution5625 {
    fun numberOfMatches(n: Int): Int {
        var res = 0
        var t = n
        while (t > 1) {
            val v = t / 2 + t % 2
            res += t / 2
            t = v
        }
        return res
    }
}