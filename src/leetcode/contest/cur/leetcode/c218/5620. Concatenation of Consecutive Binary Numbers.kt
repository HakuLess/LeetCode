package leetcode.contest.cur.leetcode.c218

import leetcode.contest.utils.print
import java.math.BigInteger
import kotlin.math.pow

fun main(args: Array<String>) {
    val s = Solution5620()
    s.concatenatedBinary(3).print()
}

class Solution5620 {
    fun concatenatedBinary(n: Int): Int {
        val mod = 1000000007L.toBigInteger()
        var cur = BigInteger.ZERO
        var multi = BigInteger.ONE
        for (i in n downTo 1) {
            cur += i.toBigInteger() * multi
            multi *= Math.pow(2.0, n.toString(2).length.toDouble()).toInt().toBigInteger()
        }
        return cur.mod(mod).toInt()
    }
}