package leetcode.contest.last.c149

import leetcode.contest.utils.print
import java.math.BigInteger

fun main(args: Array<String>) {
    val s = Solution1155()
//    s.numRollsToTarget(1, 6, 3).print()
//    s.numRollsToTarget(2, 6, 7).print()
//    s.numRollsToTarget(2, 5, 10).print()
//    s.numRollsToTarget(1, 2, 3).print()
    s.numRollsToTarget(30, 30, 500).print()
}

class Solution1155 {

    fun numRollsToTarget(d: Int, f: Int, target: Int): Int {
        val mod = 1000000007L
        val seen = HashMap<Pair<Int, Int>, Long>()
        fun dfs(cur: Int, left: Int): Long {
            val key = Pair(cur, left)
            if (key in seen) {
                return seen[key]!!
            }
            if (cur == 0 && left != 0) return 0L
            if (cur == 0 && left == 0) return 1L
            var ans = 0L
            for (i in 1..f) {
                if (left < i) break
                ans += dfs(cur - 1, left - i)
                ans %= mod
            }
            return ans.also {
                seen[key] = it
            }
        }
        return dfs(d, target).toInt()
    }
}