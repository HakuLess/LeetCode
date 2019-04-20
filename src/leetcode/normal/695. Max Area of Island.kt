package leetcode.normal

import java.util.*

class Solution695 {
    var max = 0
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) {
            return 0
        }

        for (i in 0 until grid.size) {
            for (j in 0 until grid[0].size) {
                getMaxArea(grid, i, j)
            }
        }
        return max
    }

    private fun getMaxArea(grid: Array<IntArray>, i: Int, j: Int) {
        if (grid[i][j] <= 0) {
            return
        }
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.add(Pair(i, j))
        var count = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (c in 0 until size) {
                val item = queue.poll()
                val island = island(grid, item.first, item.second)
                if (island > 0) {
                    count++
                    queue.add(Pair(item.first + 1, item.second))
                    queue.add(Pair(item.first - 1, item.second))
                    queue.add(Pair(item.first, item.second + 1))
                    queue.add(Pair(item.first, item.second - 1))
                }
            }
        }
        max = maxOf(max, count)
    }

    private fun island(grid: Array<IntArray>, i: Int, j: Int): Int {
        if (i < 0 || i >= grid.size) {
            return 0
        }
        if (j < 0 || j >= grid[0].size) {
            return 0
        }

        val ans = grid[i][j]
        grid[i][j] = -1
        return ans
    }
}