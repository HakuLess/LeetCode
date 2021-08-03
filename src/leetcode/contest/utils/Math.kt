package leetcode.contest.utils

import java.math.BigInteger
import java.util.ArrayList

/**
 * 数学相关操作
 *
 * 排列组合数
 * 快速幂
 * 素数
 * 全排列
 * */

// 阶乘
// 乘法逆元计算
fun fac(n: Int, mod: Long = 1000000007L): Pair<LongArray, LongArray> {
    val fac = LongArray(n + 1)
    fac[0] = 1
    val invFac = LongArray(n + 1)
    invFac[0] = 1
    for (i in 1..n) {
        fac[i] = fac[i - 1] * i % mod
        invFac[i] = inv(fac[i], mod)
    }
    // first: 阶乘数
    // second: 乘法逆元
    // 乘以a的阶乘，使用*fac[a]
    // 除以a的阶乘，使用*invFac[a]
    return Pair(fac, invFac)
}

fun fexp(x: Long, y: Long, mod: Long): Long {
    var x: Long = x
    var y: Long = y
    var ans: Long = 1
    while (y != 0L) {
        if (y and 1 != 0L) ans = ans * x % mod
        x = x * x % mod
        y = y shr 1
    }
    return ans
}

fun inv(x: Long, mod: Long = 1000000007L): Long {
    return fexp(x, mod - 2, mod)
}

// 组合
fun C(n: Int, m: Int, mod: Long = 1000000007L): Long {
    return fac(n, mod).let {
        it.first[n] * it.second[m] % mod
    }
}


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

// 无重复数组，全排列
fun IntArray.permute(): List<List<Int>> {
    val ans = ArrayList<List<Int>>()
    fun backtrack(nums: IntArray, tracker: ArrayList<Int>) {
        if (tracker.size == nums.size) {
            ans.add(ArrayList(tracker))
            return
        }
        for (num in nums) {
            if (tracker.contains(num)) {
                continue
            }
            tracker.add(num)
            backtrack(nums, tracker)
            tracker.remove(num)
        }
    }
    backtrack(this, arrayListOf())
    return ans
}