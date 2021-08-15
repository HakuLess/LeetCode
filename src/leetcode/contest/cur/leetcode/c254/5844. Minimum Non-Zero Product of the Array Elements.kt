package leetcode.contest.cur.leetcode.c254

import leetcode.contest.utils.print
import leetcode.contest.utils.quickPower

fun main(args: Array<String>) {
    val s = Solution5844()
    s.minNonZeroProduct(30).print()
}

class Solution5844 {
    fun minNonZeroProduct(p: Int): Int {
        val mod = 1000000007L.toBigInteger()
        // 3
        val n = (quickPower(2L.toBigInteger(), p.toLong().toBigInteger(), -1) - 1.toBigInteger()) / 2.toBigInteger()
        // 6
        val m = quickPower(2L.toBigInteger(), p.toLong().toBigInteger(), -1) - 2L.toBigInteger()
        val ans = quickPower(m, n) * (quickPower(2L.toBigInteger(), p.toLong().toBigInteger()) - 1L.toBigInteger())
        return (ans % mod).toInt()
    }
}