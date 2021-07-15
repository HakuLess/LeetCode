package leetcode.contest.last.b56

import java.util.*
import kotlin.collections.HashSet

class Solution5793 {
    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        val ori = arrayOf(
                intArrayOf(-1, 0),
                intArrayOf(0, -1),
                intArrayOf(0, 1),
                intArrayOf(1, 0)
        )
        val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
        queue.add(Pair(entrance[0], entrance[1]))
        var step = -1
        val seen = HashSet<Pair<Int, Int>>()
        seen.add(Pair(entrance[0], entrance[1]))
        while (queue.isNotEmpty()) {
            val size = queue.size
            step++
            for (i in 0 until size) {
                val item = queue.poll()
                if ((item.first == 0 || item.first == maze.lastIndex)
                        && !(item.first == entrance[0] && item.second == entrance[1])) return step
                if ((item.second == 0 || item.second == maze[0].lastIndex)
                        && !(item.first == entrance[0] && item.second == entrance[1])) return step
                ori.forEach {
                    val next = Pair(item.first + it[0], item.second + it[1])
                    if (next !in seen
                            && next.first in maze.indices
                            && next.second in maze[0].indices
                            && maze[next.first][next.second] == '.') {
                        queue.offer(next)
                        seen.add(next)
                    }
                }
            }
        }
        return -1
    }
}