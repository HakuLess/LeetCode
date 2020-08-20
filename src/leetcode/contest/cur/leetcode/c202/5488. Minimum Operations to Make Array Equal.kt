package leetcode.contest.cur.leetcode.c202

class Solution5488 {
    fun minOperations(n: Int): Int {
        if (n <= 1) return 0
        val mid = (1 + 2 * n - 1) / 2
        var ans = 0
        var i = 1
        while (i < mid) {
            ans += mid - i
            i += 2
        }
        return ans
    }
}