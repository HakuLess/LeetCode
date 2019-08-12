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

    val map = HashMap<Pair<Int, Int>, BigInteger>()

    private val mod = 1000000007L

    fun numRollsToTarget(d: Int, f: Int, target: Int): Int {
        return (cal(0, target, d, f).mod(BigInteger.valueOf(mod))).toInt()
    }

    private fun cal(cur: Int, target: Int, d: Int, f: Int): BigInteger {
        if (map[Pair(cur, d)] != null) {
            return map[Pair(cur, d)]!!
        }

        if (cur == target && d == 0) {
            return BigInteger.ONE
        }
        if (cur > target || d <= 0) {
            return BigInteger.ZERO
        }
        var ans = BigInteger.valueOf(0)
        for (i in 1..f) {
            ans = ans.add(cal(cur + i, target, d - 1, f))
        }
        map[Pair(cur, d)] = ans
        return ans
    }
}