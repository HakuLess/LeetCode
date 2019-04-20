package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    countPrimes(7).print()
}

fun countPrimes(n: Int): Int {
    if (n == 1 || n == 2) {
        return 0
    }
    var result = 0
    for (i in 2 until n) {
        if (isPrime(i)) {
            i.print()
            result++
        }
    }
    return result
}

fun isPrime(n: Int): Boolean {
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