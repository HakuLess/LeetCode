package leetcode

import java.util.*

class Solution200 {
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) {
            return 0
        }

        var ans = 0
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        for (i in 0 until grid.size) {
            for (j in 0 until grid[0].size) {
                if (grid[i][j] == '1') {
                    queue.add(Pair(i, j))
                    ans--

                    while (queue.isNotEmpty()) {
                        val pos = queue.poll()
                        val x = pos.first
                        val y = pos.second
                        grid[x][y] = ans.toChar()
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            grid[x - 1][y] = ans.toChar()
                            queue.offer(Pair(x - 1, y))
                        }
                        if (x + 1 < grid.size && grid[x + 1][y] == '1') {
                            grid[x + 1][y] = ans.toChar()
                            queue.offer(Pair(x + 1, y))
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            grid[x][y - 1] = ans.toChar()
                            queue.offer(Pair(x, y - 1))
                        }
                        if (y + 1 < grid[0].size && grid[x][y + 1] == '1') {
                            grid[x][y + 1] = ans.toChar()
                            queue.offer(Pair(x, y + 1))
                        }
                    }
                }
            }
        }

        return -ans
    }
}