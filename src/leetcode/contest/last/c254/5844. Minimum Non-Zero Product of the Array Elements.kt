package leetcode.contest.last.c254

import leetcode.contest.utils.print
import leetcode.contest.utils.quickPower

fun main(args: Array<String>) {
    val s = Solution5844()
    s.minNonZeroProduct(30).print()
}

class Solution5844 {
    fun minNonZeroProduct(p: Int): Int {
        val mod = 1000000007L
        val a = (1L shl p) - 1L
        val b = a - 1L
        val c = b / 2L
        return (((a % mod) * quickPower(b % mod, c)) % mod).toInt()
    }
}