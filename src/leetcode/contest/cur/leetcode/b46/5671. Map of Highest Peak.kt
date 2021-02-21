package leetcode.contest.cur.leetcode.b46

import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid

fun main(args: Array<String>) {
    val s = Solution5671()
    s.highestPeak("[[0,1],[0,0]]".toGrid()).print()
}

class Solution5671 {
    fun highestPeak(isWater: Array<IntArray>): Array<IntArray> {
        val n = isWater.size
        val m = isWater[0].size
        val ans = Array<IntArray>(n) { IntArray(m) { -1 } }
        var cur = arrayListOf<Pair<Int, Int>>()
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (isWater[i][j] == 1) {
                    ans[i][j] = 0
                    cur.add(Pair(i, j))
                }
            }
        }
        val dirs = arrayListOf(Pair(0, 1), Pair(-1, 0), Pair(0, -1), Pair(1, 0))
        var index = 0
        while (cur.isNotEmpty()) {
            index++
            val next = arrayListOf<Pair<Int, Int>>()
            for ((i, j) in cur) {
                for ((x, y) in dirs) {
                    val ni = x + i
                    val nj = y + j
                    if (ni in 0 until n && nj in 0 until m && ans[ni][nj] == -1) {
                        ans[ni][nj] = index
                        next.add(Pair(ni, nj))
                    }
                }
            }
            cur = next
        }
        return ans
    }
}