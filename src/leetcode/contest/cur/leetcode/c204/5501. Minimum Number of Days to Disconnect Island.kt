package leetcode.contest.cur.leetcode.c204

import java.util.*
import kotlin.collections.HashSet

class Solution5501 {
    fun minDays(grid: Array<IntArray>): Int {
        if (check(grid)) {
            return 0
        }
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 2
                    if (check(grid)) return 1
                    grid[i][j] = 1
                }
            }
        }
        return 2
    }

    private fun check(grid: Array<IntArray>): Boolean {
        var start = Pair(0, 0)
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 1) {
                    start = Pair(i, j)
                }
            }
        }

        val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
        queue.add(start)
        val seen = HashSet<Pair<Int, Int>>()
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                if (item.first !in grid.indices || item.second !in grid[0].indices) continue
                if (item in seen) continue
                seen.add(item)
                if (grid[item.first][item.second] == 1) {
                    queue.offer(Pair(item.first - 1, item.second))
                    queue.offer(Pair(item.first + 1, item.second))
                    queue.offer(Pair(item.first, item.second - 1))
                    queue.offer(Pair(item.first, item.second + 1))
                    grid[item.first][item.second] = 2
                }
            }
        }

        val ans = grid.any { it.contains(1) }
        grid.forEach {
            it.forEachIndexed { index, i ->
                if (i == 2) {
                    it[index] = 1
                }
            }
        }
        return ans
    }

}