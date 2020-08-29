package leetcode.contest.cur.atcoder.abc177

import java.math.BigInteger

fun main(args: Array<String>) {
    val n = readLine()!!.toLong()
    val a = readLine()!!.split(' ').map { it.toLong() }

    val sum = a.sum()
    val mod = 1000000007L
    var ans = BigInteger.valueOf(0L)
    a.forEach {
        ans = ans.add(BigInteger.valueOf(it).multiply(BigInteger.valueOf(sum - it)))
    }
    ans = ans.divide(BigInteger.TWO)
    ans = ans.mod(BigInteger.valueOf(mod))
    println(ans)
}