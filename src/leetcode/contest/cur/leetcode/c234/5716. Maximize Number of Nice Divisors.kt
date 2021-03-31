package leetcode.contest.cur.leetcode.c234

import leetcode.contest.utils.quickPower
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5716()
//    s.maxNiceDivisors(835846393).print()
//    s.maxNiceDivisors(5).print()
//    s.maxNiceDivisors(8).print()
    s.maxNiceDivisors(73).print()
}

class Solution5716 {
    fun maxNiceDivisors(primeFactors: Int): Int {
        if (primeFactors == 1) return 1
        val mod = 1000000007L
        var ans = 1L
        val c = primeFactors / 3
        when (primeFactors % 3) {
            1 -> {
                ans = quickPower(3, (c - 1).toLong(), mod) * 4
            }
            2 -> {
                ans = quickPower(3, (c).toLong(), mod) * 2
            }
            0 -> {
                ans = quickPower(3, (c).toLong(), mod)
            }
        }
        return (ans % mod).toInt()
    }
}