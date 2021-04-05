package leetcode.contest.cur.`2020`.q3

import leetcode.contest.utils.print
import java.math.BigInteger

fun main(args: Array<String>) {
    val s = Solution4()
//    s.busRapidTransit(31, 5, 3, intArrayOf(6), intArrayOf(10)).print()
//    s.busRapidTransit(612, 4, 5, intArrayOf(3, 6, 8, 11, 5, 10, 4), intArrayOf(4, 7, 6, 3, 7, 6, 4)).print()
    s.busRapidTransit(954116209, 725988, 636911, intArrayOf(524425, 158389), intArrayOf(41881, 941330)).print()
}

class Solution4 {
    fun busRapidTransit(target: Int, inc: Int, dec: Int, jump: IntArray, cost: IntArray): Int {
        val mod = (1e9 + 7).toLong()
        val seen = HashMap<Long, Long>()
        seen[0] = 0L
        fun dfs(curIndex: Long): Long {
            if (curIndex in seen) {
                return seen[curIndex]!!
            }
            var ans = curIndex * inc.toLong()
            seen[curIndex] = ans
            for (i in jump.indices) {
                if (jump[i] == 1) continue
                val m = curIndex % jump[i]
                ans = minOf(ans, dfs(curIndex / jump[i]) + m * inc + cost[i])
                ans = minOf(ans, dfs((curIndex + jump[i] - m) / jump[i]) + (jump[i] - m) * dec + cost[i])
            }
            return ans.also {
                seen[curIndex] = it
            }
        }
        dfs(target.toLong())
        return (seen[target.toLong()]!! % mod).toInt()
    }
}