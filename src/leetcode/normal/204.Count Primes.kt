package leetcode.normal

import java.util.*

class Solution204 {
    fun countPrimes(n: Int): Int {
        val primes = ArrayList<Int>()
        val isPrime = IntArray(n) { 1 }
        for (i in 2 until n) {
            if (isPrime[i] == 1) {
                primes.add(i)
            }
            var j = 0
            while (j < primes.size && i * primes[j] < n) {
                isPrime[i * primes[j]] = 0
                if (i % primes[j] == 0) {
                    break
                }
                ++j
            }
        }
        return primes.size
    }
}