package leetcode.contest.last.c141

import java.util.*

class Solution1091 {
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        val ori = arrayOf(
            Pair(-1, -1),
            Pair(-1, 0),
            Pair(-1, 1),
            Pair(0, -1),
            Pair(0, 1),
            Pair(1, -1),
            Pair(1, 0),
            Pair(1, 1)
        )
        var step = 0
        val seen = hashSetOf<Pair<Int, Int>>()
        val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
        queue.add(Pair(0, 0))
        while (queue.isNotEmpty()) {
            val size = queue.size
            step++
            for (i in 0 until size) {
                val item = queue.poll()
                if (item.first in grid.indices
                    && item.second in grid.indices
                    && item !in seen
                    && grid[item.first][item.second] == 0
                ) {
                    if (item.second == grid.lastIndex && item.first == grid.lastIndex) {
                        return step
                    }
                    seen.add(Pair(item.first, item.second))
                    ori.forEach {
                        queue.offer(Pair(item.first + it.first, item.second + it.second))
                    }
                }
            }
        }
        return -1
    }
}