package leetcode.contest.cur.b20

import leetcode.contest.utils.print
import java.math.BigInteger

fun main(args: Array<String>) {
    val s = Solution5326()
    s.countOrders(2).print()
    s.countOrders(3).print()
    s.countOrders(4).print()
    s.countOrders(18).print()
}

class Solution5326 {
    fun countOrders(n: Int): Int {
        val mod = 1000000007
        var ans = BigInteger.valueOf(1)
        for (i in 1..(n * 2)) {
            ans = ans.multiply(BigInteger.valueOf(i.toLong()))
        }
        for (i in 1..n) {
            ans = ans.divide(BigInteger.valueOf(2L))
        }
        return (ans.remainder(BigInteger.valueOf(mod.toLong()))).toInt()
    }
}