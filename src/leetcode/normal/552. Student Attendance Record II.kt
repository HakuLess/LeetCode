package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution552()
    s.checkRecord(3999).print()

    val f = Solution552f()
    f.checkRecord(3999).print()
//    s.checkRecord(3999).print()
}

class Solution552 {
    private val mod = 1000000007
    fun checkRecord(n: Int): Int {
        val dpA = IntArray(n)
        val dp0AP = IntArray(n)
        val dp1AP = IntArray(n) { 0 }
        val dp0A1L = IntArray(n)
        val dp0A2L = IntArray(n) { 0 }
        val dp1A1L = IntArray(n) { 0 }
        val dp1A2L = IntArray(n) { 0 }

        dpA[0] = 1
        dp0AP[0] = 1
        dp0A1L[0] = 1
        for (i in 1 until n) {
            // A
            dpA[i] += dp0A1L[i - 1]
            dpA[i] %= mod
            dpA[i] += dp0A2L[i - 1]
            dpA[i] %= mod
            dpA[i] += dp0AP[i - 1]
            dpA[i] %= mod
            // P
            dp0AP[i] += dp0A1L[i - 1]
            dp0AP[i] %= mod
            dp0AP[i] += dp0A2L[i - 1]
            dp0AP[i] %= mod
            dp0AP[i] += dp0AP[i - 1]
            dp0AP[i] %= mod

            dp1AP[i] += dp1A1L[i - 1]
            dp1AP[i] %= mod
            dp1AP[i] += dp1A2L[i - 1]
            dp1AP[i] %= mod
            dp1AP[i] += dp1AP[i - 1]
            dp1AP[i] %= mod
            dp1AP[i] += dpA[i - 1]
            dp1AP[i] %= mod
            // L
            dp0A1L[i] = dp0AP[i - 1]
            dp0A2L[i] = dp0A1L[i - 1]
            dp1A1L[i] = dp1AP[i - 1] + dpA[i - 1]
            dp1A2L[i] = dp1A1L[i - 1]
            dp0A1L[i] %= mod
            dp0A2L[i] %= mod
            dp1A1L[i] %= mod
            dp1A2L[i] %= mod
        }

        var ans = 0
        ans += dpA[n - 1]
        ans %= mod
        ans += dp0AP[n - 1]
        ans %= mod
        ans += dp1AP[n - 1]
        ans %= mod
        ans += dp0A1L[n - 1]
        ans %= mod
        ans += dp0A2L[n - 1]
        ans %= mod
        ans += dp1A1L[n - 1]
        ans %= mod
        ans += dp1A2L[n - 1]
        ans %= mod
        return ans
    }
}

class Solution552f {
    val mod = 1000000007
    val map = hashMapOf<Triple<Int, Int, Int>, Int>()
    fun checkRecord(n: Int): Int {
        return dfs(0, n, 0, 0)
    }

    private fun dfs(cur: Int, n: Int, l: Int, a: Int): Int {
        if (cur == n) {
            return 1
        }
        val key = Triple(cur, l, a)
        if (map.containsKey(key)) {
            return map[key]!!
        }
        var ans = 0
        // just P
        ans += dfs(cur + 1, n, 0, a) % mod
        ans %= mod
        // A
        if (a == 0) {
            ans += dfs(cur + 1, n, 0, 1) % mod
            ans %= mod
        }
        if (l < 2) {
            ans += dfs(cur + 1, n, l + 1, a) % mod
            ans %= mod
        }
        map[Triple(cur, l, a)] = ans % mod
        return ans % mod
    }
}