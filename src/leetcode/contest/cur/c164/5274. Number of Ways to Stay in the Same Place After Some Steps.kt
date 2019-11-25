package leetcode.contest.cur.c164

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5274()
    s.numWays(3, 2).print()
    s.numWays(2, 4).print()
    s.numWays(4, 2).print()
}

class Solution5274 {

    val mod = 1000000007
    val seen = HashMap<Pair<Int, Int>, Int>()
    fun numWays(steps: Int, arrLen: Int): Int {
        return helper(steps, arrLen, 0)
    }

    private fun helper(steps: Int, arrLen: Int, cur: Int): Int {
        if (Pair(steps, cur) in seen) {
            return seen[Pair(steps, cur)]!!
        }
        if (steps == 0) {
            return if (cur == 0) {
                1
            } else {
                0
            }
        }
        var ans = helper(steps - 1, arrLen, cur)
        ans += if (cur + 1 in 0 until arrLen) helper(steps - 1, arrLen, cur + 1) else 0
        ans %= mod
        ans += if (cur - 1 in 0 until arrLen) helper(steps - 1, arrLen, cur - 1) else 0
        ans %= mod
        seen[Pair(steps, cur)] = ans
        return ans
    }
}