package leetcode.contest.cur.c162

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5257()
    s.closedIsland(arrayOf(
            intArrayOf(1, 1, 1, 1, 1, 1, 1, 0),
            intArrayOf(1, 0, 0, 0, 0, 1, 1, 0),
            intArrayOf(1, 0, 1, 0, 1, 1, 1, 0),
            intArrayOf(1, 0, 0, 0, 0, 1, 0, 1),
            intArrayOf(1, 1, 1, 1, 1, 1, 1, 0)
    )).print()
}

class Solution5257 {

    fun closedIsland(grid: Array<IntArray>): Int {
        var ans = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                ans += search(i, j, grid)
            }
        }
        return ans
    }

    private fun search(x: Int, y: Int, grid: Array<IntArray>): Int {
        var ans = 0
        val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
        if (grid[x][y] == 0) {
            ans = 1
            queue.add(Pair(x, y))
        }
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                if (item.first !in grid.indices || item.second !in grid[0].indices) {
                    ans = 0
                    continue
                }
                if (grid[item.first][item.second] == 0) {
                    queue.offer(Pair(item.first + 1, item.second))
                    queue.offer(Pair(item.first - 1, item.second))
                    queue.offer(Pair(item.first, item.second + 1))
                    queue.offer(Pair(item.first, item.second - 1))

                    grid[item.first][item.second] = -1
                }
            }
        }
        return ans
    }
}