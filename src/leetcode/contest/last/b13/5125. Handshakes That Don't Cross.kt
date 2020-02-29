package leetcode.contest.last.b13

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5125()
    s.numberOfWays(2).print()
    s.numberOfWays(4).print()
    s.numberOfWays(6).print()
    s.numberOfWays(8).print()
    s.numberOfWays(140).print()
}

class Solution5125 {
    fun numberOfWays(num_people: Int): Int {
        val mod = 1000000007
        val dp = IntArray(num_people + 1)
        dp[0] = 1
        for (i in 2..num_people step 2) {
            for (j in 0..i - 2 step 2) {
                dp[i] += ((dp[j].toLong() * dp[i - 2 - j].toLong()) % mod).toInt()
                dp[i] %= mod
            }
        }
        return dp[num_people]
    }
}