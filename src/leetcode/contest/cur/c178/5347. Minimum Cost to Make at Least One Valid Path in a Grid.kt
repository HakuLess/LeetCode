package leetcode.contest.cur.c178

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5347()
    s.minCost(arrayOf(
            intArrayOf(1, 1, 1, 1),
            intArrayOf(2, 2, 2, 2),
            intArrayOf(1, 1, 1, 1),
            intArrayOf(2, 2, 2, 2)
    )).print()
}

class Solution5347 {
    fun minCost(grid: Array<IntArray>): Int {
        val matrix = Array<IntArray>(grid.size) { IntArray((grid[0].size)) { 10000 } }
        helper(grid, 0, 0, matrix)
        return matrix.last().last()
    }

    private fun helper(grid: Array<IntArray>, x: Int, y: Int, matrix: Array<IntArray>) {
        val queue: Queue<Triple<Int, Int, Int>> = LinkedList<Triple<Int, Int, Int>>()
        queue.add(Triple(x, y, 0))
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                if (item.first !in grid.indices || item.second !in grid[0].indices) {
                    continue
                }
                if (item.third < matrix[item.first][item.second]) {
                    matrix[item.first][item.second] = item.third

                    when (grid[item.first][item.second]) {
                        1 -> queue.offer(Triple(item.first, item.second + 1, item.third))
                        2 -> queue.offer(Triple(item.first, item.second - 1, item.third))
                        3 -> queue.offer(Triple(item.first + 1, item.second, item.third))
                        4 -> queue.offer(Triple(item.first - 1, item.second, item.third))
                    }

                    queue.offer(Triple(item.first, item.second + 1, item.third + 1))
                    queue.offer(Triple(item.first, item.second - 1, item.third + 1))
                    queue.offer(Triple(item.first + 1, item.second, item.third + 1))
                    queue.offer(Triple(item.first - 1, item.second, item.third + 1))
                }
            }
        }
    }
}