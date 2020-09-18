package leetcode.contest.cur.atcoder.abc178

import leetcode.contest.utils.comb
import java.math.BigInteger

fun main(args: Array<String>) {
    val mod = (1e9 + 7).toInt().toBigInteger()
    val n = readLine()!!.toInt()
    if (n < 2) {
        println(0)
        return
    }
    println((10.toBigInteger().pow(n) - 9.toBigInteger().pow(n) * 2.toBigInteger() + 8.toBigInteger().pow(n)).mod(mod))
}