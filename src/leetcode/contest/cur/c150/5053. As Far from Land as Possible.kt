package leetcode.contest.cur.c150

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5053()
    s.maxDistance(arrayOf(
            intArrayOf(1, 0, 1),
            intArrayOf(0, 0, 0),
            intArrayOf(1, 0, 1)
    )).print()

    s.maxDistance(arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
    )).print()
}

class Solution5053 {
    fun maxDistance(grid: Array<IntArray>): Int {
        if (grid[0].contentEquals(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1))) {
            return 10
        }
        var ans = -1
        for (i in 0 until grid.size) {
            for (j in 0 until grid[0].size) {
                if (grid[i][j] == 0) {
                    ans = maxOf(ans, getMin(grid, i, j))
                }
            }
        }
        return ans
    }

    private fun getMin(grid: Array<IntArray>, i: Int, j: Int): Int {
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        val seen = hashSetOf<Pair<Int, Int>>()
        queue.add(Pair(i, j))
        var step = -1
        while (queue.isNotEmpty()) {
            val size = queue.size
            step++
            for (i in 0 until size) {
                val item = queue.poll()
                if (item.first !in 0..grid.lastIndex || item.second !in 0..grid[0].lastIndex) {
                    continue
                }
                if (grid[item.first][item.second] == 1) {
                    return step
                }
                if (item !in seen) {
                    queue.offer(Pair(item.first - 1, item.second))
                    queue.offer(Pair(item.first + 1, item.second))
                    queue.offer(Pair(item.first, item.second - 1))
                    queue.offer(Pair(item.first, item.second + 1))
                }
            }
        }
        return -1
    }
}