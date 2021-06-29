package leetcode.contest.utils

import java.math.BigInteger
import java.util.ArrayList

/**
 * 数学相关操作
 *
 * 排列组合数
 * 快速幂
 * 素数
 * */

// 线性筛出法
// 获取0..N的素数的个数
fun Int.countPrime(): Int {
    val primes = ArrayList<Int>()
    val isPrime = IntArray(this) { 1 }
    for (i in 2 until this) {
        if (isPrime[i] == 1) {
            primes.add(i)
        }
        var j = 0
        while (j < primes.size && i * primes[j] < this) {
            isPrime[i * primes[j]] = 0
            if (i % primes[j] == 0) {
                break
            }
            ++j
        }
    }
    return primes.size
}

/**
 * 快速幂
 * 计算 base 的 pow 次方，并且求其 %m 后的结果
 * */
fun quickPower(base: Long, pow: Long, m: Long = 1000000007L): Long {
    var res = 1L
    var a = base
    var b = pow
    while (b > 0) {
        if (b and 1L != 0L)
            res = res * a % m
        a = a * a % m
        b = b shr 1
    }
    return res
}

/**
 * GCD 最大公约数
 * */
tailrec fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}

tailrec fun gcd(a: Long, b: Long): Long {
    return if (b == 0L) a else gcd(b, a % b)
}

tailrec fun gcd(a: BigInteger, b: BigInteger): BigInteger {
    return if (b == BigInteger.ZERO) a else gcd(b, a % b)
}

/**
 * LCM 最小公倍数
 * */
fun lcm(a: Long, b: Long): Long {
    return a / gcd(a, b) * b
}

fun lcm(a: BigInteger, b: BigInteger): BigInteger {
    return a / gcd(a, b) * b
}