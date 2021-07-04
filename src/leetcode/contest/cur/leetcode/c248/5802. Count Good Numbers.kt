package leetcode.contest.cur.leetcode.c248

import leetcode.contest.utils.quickPower

class Solution5802 {
    fun countGoodNumbers(n: Long): Int {
        val mod = 1000000007L
        val a = quickPower(5, n - n / 2)
        val b = quickPower(4, n / 2)
        return (a * b % mod).toInt()
    }
}