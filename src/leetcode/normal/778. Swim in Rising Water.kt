package leetcode.normal

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val a = Solution778()
//    a.swimInWater(
//            arrayOf(
//                    intArrayOf(0, 2),
//                    intArrayOf(1, 3)
//            )
//    ).print()

//    [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
    a.swimInWater(
            arrayOf(
                    intArrayOf(0, 1, 2, 3, 4),
                    intArrayOf(24, 23, 22, 21, 5),
                    intArrayOf(12, 13, 14, 15, 16),
                    intArrayOf(11, 17, 18, 19, 20),
                    intArrayOf(10, 9, 8, 7, 6)
            )
    ).print()
}

class Solution778 {
    fun swimInWater(grid: Array<IntArray>): Int {
        val n = grid.size
        val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
        queue.add(Pair(0, 0))

        val ans = Array(grid.size) { IntArray(grid.size) { Int.MAX_VALUE } }

        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                if (item.first < 0 || item.second < 0
                        || item.first >= n || item.second >= n) {
                    continue
                }

                val min = getMin(grid, ans, item.first, item.second)
//                println("min: $min")
                if (ans[item.first][item.second] > min) {
                    ans[item.first][item.second] = min
                    queue.add(Pair(item.first - 1, item.second))
                    queue.add(Pair(item.first + 1, item.second))
                    queue.add(Pair(item.first, item.second - 1))
                    queue.add(Pair(item.first, item.second + 1))
                }
            }
        }

//        ans.print()
        return ans[n - 1][n - 1]
    }

    private fun getMin(grid: Array<IntArray>, ans: Array<IntArray>, x: Int, y: Int): Int {
        if (x == 0 && y == 0) {
            return grid[0][0]
        }

        var result = Int.MAX_VALUE

        if (x != 0) {
            result = minOf(result, ans[x - 1][y])
        }
        if (x != grid.lastIndex) {
            result = minOf(result, ans[x + 1][y])
        }
        if (y != 0) {
            result = minOf(result, ans[x][y - 1])
        }
        if (y != grid.lastIndex) {
            result = minOf(result, ans[x][y + 1])
        }

        result = maxOf(grid[x][y], result)

//        println("$x, $y : $result")

        return result
    }
}