package leetcode.contest.last.c152

import leetcode.contest.utils.fac
import leetcode.contest.utils.getPrime
import leetcode.contest.utils.print
import leetcode.contest.utils.quickPower
import java.math.BigInteger

fun main(args: Array<String>) {
    val s = Solution5173()
    s.numPrimeArrangements(5).print()
    s.numPrimeArrangements(100).print()
}

class Solution5173 {
    fun numPrimeArrangements(n: Int): Int {
        val mod = 1000000007
        val fac = fac(100).first
        // 0 和 1 不算质数，需要减去2
        val a = getPrime(n).count { it == 1 } - 2
        val b = n - a
        val ans = (fac[a] * fac[b]) % mod
        return ans.toInt()
    }
}
