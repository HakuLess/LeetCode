package leetcode.contest.cur.leetcode.c228

class Solution5677 {
    fun countHomogenous(s: String): Int {
        val mod = 1000000007L
        var ans = 0L
        var left = s[0]
        var cnt = 0
        s.forEach {
            if (it == left) {
                cnt++
                ans += cnt
            } else {
                cnt = 1
                left = it
                ans++
            }
        }
        return (ans % mod).toInt()
    }
}