package leetcode.contest.cur.leetcode.b46

import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5671()
    s.highestPeak("[[0,1],[0,0]]".toGrid()).print()
}

class Solution5671 {
    fun highestPeak(isWater: Array<IntArray>): Array<IntArray> {
        val n = isWater.size
        val m = isWater[0].size
        val ans = Array<IntArray>(n) { IntArray(m) { -1 } }
        val dirs = arrayListOf(Pair(0, 1), Pair(-1, 0), Pair(0, -1), Pair(1, 0))
        val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
        for (i in 0 until n)
            for (j in 0 until m)
                if (isWater[i][j] == 1)
                    queue.add(Pair(i, j))
        var step = -1
        while (queue.isNotEmpty()) {
            val size = queue.size
            step++
            for (i in 0 until size) {
                val item = queue.poll()
                if (ans[item.first][item.second] != -1) continue
                ans[item.first][item.second] = step
                for (dir in dirs) {
                    val next = Pair(item.first + dir.first, item.second + dir.second)
                    if (next.first in 0 until n && next.second in 0 until m) {
                        queue.offer(next)
                    }
                }
            }
        }
        return ans
    }
}