package leetcode.contest.cur.leetcode.c218

class Solution5620 {
    fun concatenatedBinary(n: Int): Int {
        val mod = 1000000007
        var res = 0L
        for (i in 1..n) {
            val len = i.toString(2).length
            res = ((res shl len) % mod + i) % mod
        }
        return res.toInt()
    }
}