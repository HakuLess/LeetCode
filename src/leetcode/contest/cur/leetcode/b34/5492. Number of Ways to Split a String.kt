package leetcode.contest.cur.leetcode.b34

import leetcode.contest.utils.print
import java.math.BigInteger

fun main(args: Array<String>) {
    val s = Solution5492()
    s.numWays("100100010100110").print()
    s.numWays("10101").print()
    s.numWays("0000").print()
    s.numWays("1001").print()
}

class Solution5492 {
    fun numWays(s: String): Int {
        val mod = 1000000007L.toBigInteger()
        val c = s.count { it == '1' }
        if (c == 0) return (c((s.length - 1).toBigInteger(), 2.toBigInteger()) % mod).toInt()
        if (c % 3 != 0) return 0

        val a = c / 3
        var cur = 0
        val list = arrayListOf<Int>()
        for (i in s.indices) {
            if (s[i] == '1') {
                if (cur == 0)
                    list.add(i)
                cur++
                if (cur == a) {
                    list.add(i)
                    cur = 0
                }
            }
        }
        return ((list[2] - list[1]).toBigInteger() * (list[4] - list[3]).toBigInteger()).mod(mod).toInt()
    }

    fun c(m: BigInteger, n: BigInteger): BigInteger {
        var a = 1.toBigInteger()
        var b = 1.toBigInteger()
        val qc = minOf(n, m - n)
        for (j in 0 until qc.toInt()) {
            a = a.multiply(m - j.toBigInteger())
            b = b.multiply(qc - j.toBigInteger())
        }
        return a / b
    }
}