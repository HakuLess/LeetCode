package leetcode.contest.cur.`2020`.q2

import leetcode.contest.utils.L
import leetcode.contest.utils.getPrime
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solutionq2()
//    s.splitArray(intArrayOf(2, 3, 3, 2, 3, 3)).print()
//    s.splitArray(intArrayOf(2, 3, 5, 7)).print()
    s.splitArray(intArrayOf(13, 23, 34, 47, 46)).print()
    s.splitArray(L[782581, 227, 113147, 13451, 288053, 684113, 413579, 917629, 454021, 827633, 673787, 514127, 432001, 507961, 790051, 164617, 139759, 315881, 160681, 235231, 106627, 135977, 483811, 570839, 758699, 549011, 389227, 21961, 524347, 24763, 882247, 932101, 717559, 124853, 967919, 968111, 966439, 967229, 967739, 968213, 967171, 966509, 967397, 967481, 968111, 967297, 968311, 967753, 966677, 968573, 966527, 966653, 967319, 967663, 967931, 968021, 967961, 968423, 966727, 967937, 967699, 966883, 968017, 968311, 967781, 966617, 967937, 967763, 967459, 966971, 968567, 968501, 966991, 966613, 968557, 966863, 966619, 966863, 966727, 967567, 967061, 966913, 966631, 968021, 968003, 968431, 968291, 969667, 970667, 971723, 969011, 972113, 972373, 969929, 971491, 970027, 973031, 982973, 980491, 985657].toIntArray()).print()
}

class Solutionq2 {
    fun splitArray(nums: IntArray): Int {
        val prime = getPrime(nums.max()!!)
        val dp = IntArray(nums.max()!! + 1) { Int.MAX_VALUE / 2 }
        var x = nums[0]
        while (true) {
            if (prime[x] == 1) {
                dp[x] = 1
                break
            }
            dp[prime[x]] = 1
            x /= prime[x]
        }

        var prev = 1
        for (i in 1..nums.lastIndex) {
            x = nums[i]
            var cur = Int.MAX_VALUE / 2
            while (true) {
                if (prime[x] == 1) {
                    dp[x] = minOf(dp[x], prev + 1)
                    cur = minOf(cur, dp[x])
                    break
                }
                dp[prime[x]] = minOf(dp[prime[x]], prev + 1)
                cur = minOf(cur, dp[prime[x]])
                x /= prime[x]
            }
            prev = cur
        }
        return prev
    }
}