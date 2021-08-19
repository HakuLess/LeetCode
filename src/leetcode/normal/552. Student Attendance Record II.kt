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
    fun checkRecord(n: Int): Int {
        val mod = 1000000007L

        val dpA = LongArray(n)
        val dp0AP = LongArray(n)
        val dp1AP = LongArray(n)
        val dp0A1L = LongArray(n)
        val dp0A2L = LongArray(n)
        val dp1A1L = LongArray(n)
        val dp1A2L = LongArray(n)

        dpA[0] = 1L
        dp0AP[0] = 1L
        dp0A1L[0] = 1L
        for (i in 1 until n) {
            // A
            dpA[i] += dp0A1L[i - 1] + dp0A2L[i - 1] + dp0AP[i - 1]
            dpA[i] %= mod
            // P
            dp0AP[i] += dp0A1L[i - 1] + dp0A2L[i - 1] + dp0AP[i - 1]
            dp0AP[i] %= mod

            dp1AP[i] += dp1A1L[i - 1] + dp1A2L[i - 1] + dp1AP[i - 1] + dpA[i - 1]
            dp1AP[i] %= mod

            // L
            dp0A1L[i] = dp0AP[i - 1] % mod
            dp0A2L[i] = dp0A1L[i - 1] % mod
            dp1A1L[i] = (dp1AP[i - 1] + dpA[i - 1]) % mod
            dp1A2L[i] = dp1A1L[i - 1] % mod
        }

        var ans = 0L
        ans += dpA[n - 1] + dp0AP[n - 1] + dp1AP[n - 1] + dp0A1L[n - 1] + dp0A2L[n - 1] + dp1A1L[n - 1] + dp1A2L[n - 1]
        return (ans % mod).toInt()
    }
}

class Solution552f {
    fun checkRecord(n: Int): Int {
        val mod = 1000000007
        val map = hashMapOf<Triple<Int, Int, Int>, Int>()
        fun dfs(cur: Int, n: Int, l: Int, a: Int): Int {
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
        return dfs(0, n, 0, 0)
    }
}