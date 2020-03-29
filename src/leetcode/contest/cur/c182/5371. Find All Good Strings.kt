package leetcode.contest.cur.c182

import leetcode.contest.utils.print
import java.math.BigInteger

fun main(args: Array<String>) {
    val s = Solution5371()
    s.findGoodStrings(2, "aa", "da", "b").print()
}

class Solution5371 {
    fun findGoodStrings(n: Int, s1: String, s2: String, evil: String): Int {
        val mod = 1000000007
        val a1 = getVal(s1)
        val a2 = getVal(s2)

        val e = getVal(evil)
        val c1 = getC(a1, e)
        val c2 = getC(a2, e)

        val cur = (a2 - a1 + c1 - c2).mod(BigInteger.valueOf(mod.toLong()))
        return cur.toInt()
    }

    // Din't finish
    private fun getC(a: BigInteger, e: BigInteger): BigInteger {
        var c = BigInteger.valueOf(0)
        var temp = e
        while (temp < a) {
            c = c.multiply(BigInteger.valueOf(26))
            c = c.add(BigInteger.ONE)
            temp = temp.multiply(BigInteger.valueOf(26))
        }
        return c
    }

    private fun getVal(s: String): BigInteger {
        var ans = BigInteger.valueOf(0)
        s.forEach {
            ans = ans.add(BigInteger.valueOf((it - 'a' + 1).toLong()))
            ans = ans.multiply(BigInteger.valueOf(26))
        }
        return ans.divide(BigInteger.valueOf(26))
    }
}