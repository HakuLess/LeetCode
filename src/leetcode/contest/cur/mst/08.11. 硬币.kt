package leetcode.contest.cur.mst

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution0811()
//    s.waysToChange(10).print()
    s.waysToChange(61).print()
}

class Solution0811 {
    val mod = 1000000007
    val seen = HashMap<String, Long>()

    fun waysToChange(n: Int): Int {
        val c = intArrayOf(25, 10, 5, 1)
        val dp = IntArray(n + 1) { 0 }
        dp[0] = 1
        c.forEach {
            for (i in it..n) {
                dp[i] = (dp[i] + dp[i - it]) % mod
            }
        }
        return dp[n]
    }
//    fun waysToChange(n: Int): Int {
//        return (helper(n, 25) % mod).toInt()
//    }

    private fun helper(n: Int, last: Int): Long {
        val key = "$n,$last"
        if (key in seen) {
            return seen[key]!!
        }
        if (n == 0) {
            return 1
        }
        if (n < 0) {
            return 0
        }
        var ans = 0L

        if (last == 25)
            ans = (ans + helper(n - 25, 25)) % mod
        if (last >= 10)
            ans = (ans + helper(n - 10, 10)) % mod
        if (last >= 5)
            ans = (ans + helper(n - 5, 5)) % mod
        if (last >= 1)
            ans = (ans + helper(n - 1, 1)) % mod

        seen[key] = ans
        return ans
    }
}