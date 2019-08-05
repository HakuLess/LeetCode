package leetcode.contest.last.c141

import java.util.*

class Solution1091 {
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        var step = 0
        val seen = hashSetOf<Pair<Int, Int>>()
        val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
        queue.add(Pair(0, 0))
        while (queue.isNotEmpty()) {
            val size = queue.size
            step++
            for (i in 0 until size) {
                val item = queue.poll()
                if (item.first >= 0
                        && item.second >= 0
                        && item.first < grid.size
                        && item.second < grid.size
                        && item !in seen
                        && grid[item.first][item.second] == 0) {
                    if (item.second == grid.lastIndex && item.first == grid.lastIndex) {
                        return step
                    }
                    seen.add(Pair(item.first, item.second))
                    queue.offer(Pair(item.first + 1, item.second))
                    queue.offer(Pair(item.first, item.second + 1))
                    queue.offer(Pair(item.first - 1, item.second))
                    queue.offer(Pair(item.first, item.second - 1))
                    queue.offer(Pair(item.first + 1, item.second + 1))
                    queue.offer(Pair(item.first - 1, item.second - 1))
                    queue.offer(Pair(item.first + 1, item.second - 1))
                    queue.offer(Pair(item.first - 1, item.second + 1))
                }
            }
        }
        return -1
    }
}