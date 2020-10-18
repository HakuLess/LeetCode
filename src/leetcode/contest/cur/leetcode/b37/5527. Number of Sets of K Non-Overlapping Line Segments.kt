package leetcode.contest.cur.leetcode.b37

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5527()
//    s.numberOfSets(4, 2).print()
//    s.numberOfSets(3, 1).print()
    s.numberOfSets(33, 20).print()
//    s.numberOfSets(30, 7).print()
//    s.numberOfSets(1000, 5).print()
//    s.numberOfSets(751, 201).print()
}

class Solution5527 {

    fun numberOfSets(n: Int, k: Int): Int {
        var dp = IntArray(n + 1) { 1 }
        val mod = 1000000007
        for (i in 0 until k) {
            val a = IntArray(n + 1)
            var sum = 0
            for (j in 1..n) {
                a[j] = (a[j - 1] + sum) % mod
                sum = (sum + dp[j]) % mod
            }
            dp = a
        }
        return dp[n] % mod
    }

//    val seen = HashMap<Pair<Int, Int>, Int>()
//    val mod = 1000000007
//    fun numberOfSets(n: Int, k: Int): Int {
//        val key = Pair(n, k)
//        if (key in seen) return seen[key]!!
//        if (n < k + 1) return 0
//        if (k == 0) return 1
//        if (k == 1) return n * (n - 1) / 2
//        var ans = 0L
//        for (i in 1..n - k) {
//            ans += (numberOfSets(n - i, k - 1).toLong() * i)
//            ans %= mod
//        }
//        return ans.toInt().also {
//            seen[key] = it
//        }
//    }

//    fun numberOfSets(n: Int, k: Int): Int {
//        val mod = 1000000007
//        val f = Array<IntArray>(n) { IntArray(k + 1) }
//        val g = Array<IntArray>(n) { IntArray(k + 1) }
//        f[0][0] = 1
//        g[0][0] = 1
//        for (i in 1 until n) {
//            for (j in 0..k) {
//                f[i][j] = f[i - 1][j]
//                if (j > 0)
//                    f[i][j] = (f[i][j] + g[i - 1][j - 1]) % mod
//                g[i][j] = (g[i - 1][j] + f[i][j]) % mod
//            }
//        }
//        return f[n - 1][k]
//    }
}