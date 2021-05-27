package leetcode.contest.cur.leetcode.c242

import leetcode.contest.utils.preSumArray
import leetcode.contest.utils.print

class Solution1872 {
    fun stoneGameVIII(stones: IntArray): Int {
        val n = stones.size
        val pre = stones.preSumArray().takeLast(n).map { it.toInt() }
        val f = IntArray(n)
        f[n - 1] = pre[n - 1]
        for (i in n - 2 downTo 0) {
            f[i] = maxOf(f[i + 1], pre[i] - f[i + 1])
        }
        return f[1]
    }
}