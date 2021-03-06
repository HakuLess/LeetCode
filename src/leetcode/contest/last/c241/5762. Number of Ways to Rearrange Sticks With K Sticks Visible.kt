package leetcode.contest.last.c241

import leetcode.contest.utils.print


fun main(args: Array<String>) {
    val s = Solution5762()
    s.rearrangeSticks(3, 2).print()
    s.rearrangeSticks(5, 5).print()
    s.rearrangeSticks(20, 11).print()
    s.rearrangeSticks(1000, 500).print()
    s.rearrangeSticks(994, 554).print()
}

class Solution5762 {
    // DP 动态规划
    fun rearrangeSticks(n: Int, k: Int): Int {
        val mod = 1000000007L
        val dp = Array<LongArray>(n + 1) { LongArray(k + 1) }
        dp[0][0] = 1
        for (i in 1..n) {
            for (j in 1..k) {
                dp[i][j] = (dp[i - 1][j] * (i - 1) + dp[i - 1][j - 1]) % mod
            }
        }
        return dp[n][k].toInt()
    }

//    fun rearrangeSticks(n: Int, k: Int): Int {
//        val mod = 1000000007L
//        var dp = LongArray(k + 1)
//        dp[0] = 1
//        for (i in 1..n) {
//            val g = LongArray(k + 1)
//            for (j in 1..k) {
//                g[j] = (dp[j] * (i - 1) + dp[j - 1]) % mod
//            }
//            dp = g
//        }
//        return dp[k].toInt()
//    }

    // 记忆化递归 DFS
//    fun rearrangeSticks(n: Int, k: Int): Int {
//        val mod = 1000000007L
//        val fac = HashMap<Int, Long>()
//        fac[1] = 1L
//        for (i in 2..1000) {
//            fac[i] = fac[i - 1]!! * i % mod
//        }
//        val seen = HashMap<String, Long>()
//        fun dfs(i: Int, j: Int): Long {
//            val key = "$i, $j"
//            if (key in seen) return seen[key]!!
//            if (i == j) return 1L
//            if (j == 1) return fac[i - 1]!!
//            var ans = 0L
//            ans += dfs(i - 1, j - 1) % mod
//            ans += (dfs(i - 1, j) % mod) * (i - 1) % mod
//            return ans.also {
//                seen[key] = it % mod
//            }
//        }
//        return (dfs(n, k) % (mod)).toInt()
//    }
}