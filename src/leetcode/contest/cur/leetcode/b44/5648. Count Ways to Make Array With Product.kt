package leetcode.contest.cur.leetcode.b44

import leetcode.contest.utils.longComb

class Solution5648 {
    fun waysToFillArray(queries: Array<IntArray>): IntArray {
        val mod = 1000000007L
        val primes = intArrayOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97)
        val ans = arrayListOf<Int>()
        queries.forEach {
            var (n, k) = it
            var res = 1L
            for (p in primes) {
                var c = 0L
                if (p > k) break
                while (k % p == 0) {
                    c++
                    k /= p
                }
                res *= longComb(c + n - 1, c)
                res %= mod
            }
            if (k > 1)
                res = res * n % mod
            ans.add(res.toInt())
        }
        return ans.toIntArray()
    }
}