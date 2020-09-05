package leetcode.contest.cur.leetcode.b34

import leetcode.contest.utils.print
import java.math.BigInteger
import kotlin.math.abs

fun main(args: Array<String>) {
    val s = Solution5494()
    s.countRoutes(intArrayOf(2, 3, 6, 8, 4), 1, 3, 5).print()
    s.countRoutes(intArrayOf(1, 2, 3), 0, 2, 40).print()
}

class Solution5494 {
    fun countRoutes(locations: IntArray, start: Int, finish: Int, fuel: Int): Int {
        val mod = 1000000007L.toBigInteger()
        val seen = HashMap<Pair<Int, Int>, BigInteger>()

        fun dfs(start: Int, fuel: Int): BigInteger {
            if (fuel < 0) return BigInteger.ZERO
            val key = Pair(start, fuel)
            if (key in seen) {
                return seen[key]!!
            }
            var ans = BigInteger.ZERO
            if (start == finish) ans = ans.add(BigInteger.ONE)
            for (i in locations.indices) {
                if (i != start) {
                    ans = ans.add(dfs(i, fuel - abs(locations[start] - locations[i])))
                }
            }
            return ans.also {
                seen[key] = ans
            }
        }

        return dfs(start, fuel).mod(mod).toInt()
    }
}