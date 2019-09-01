package leetcode.contest.cur.c152

import leetcode.contest.utils.print
import java.math.BigInteger

fun main(args: Array<String>) {
    val s = Solution5173()
    s.numPrimeArrangements(5).print()
    s.numPrimeArrangements(100).print()
}

class Solution5173 {
    val mod = 1000000007

    fun numPrimeArrangements(n: Int): Int {
        var a = 0
        var b = 0
        var ans = BigInteger.valueOf(1)
        for (i in 1..n) {
            if (isPrime(i)) {
                a++
            } else {
                b++
            }
        }
        for (i in 1..a) {
            ans = ans.multiply(BigInteger.valueOf(i.toLong()))
            ans = ans.mod(BigInteger.valueOf(mod.toLong()))
        }
        for (i in 1..b) {
            ans = ans.multiply(BigInteger.valueOf(i.toLong()))
            ans = ans.mod(BigInteger.valueOf(mod.toLong()))
        }
        return ans.toInt()
    }

    fun isPrime(n: Int): Boolean {
        if (n == 1) {
            return false
        }
        if (n == 2) {
            return true
        }
        val j = getMaxInt(n)
        for (i in 2..j) {
            if (n % i == 0) {
                return false
            }
        }
        return true
    }

    fun getMaxInt(n: Int): Int {
        var result = 1
        while (result * result < n) {
            result++
        }
        return result
    }
}
