package leetcode.contest.cur.c156

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5208()
    s.minimumMoves(
            arrayOf(
                    intArrayOf(0, 0, 0, 0, 0, 1),
                    intArrayOf(1, 1, 0, 0, 1, 0),
                    intArrayOf(0, 0, 0, 0, 1, 1),
                    intArrayOf(0, 0, 1, 0, 1, 0),
                    intArrayOf(0, 1, 1, 0, 0, 0),
                    intArrayOf(0, 1, 1, 0, 0, 0)
            )
    ).print()
}

class Solution5208 {
    fun minimumMoves(grid: Array<IntArray>): Int {
        val queue: Queue<IntArray> = LinkedList()
        val bottom = grid.lastIndex
        val right = grid[0].lastIndex

        val set = hashSetOf<String>()
        // tail head
        queue.add(intArrayOf(0, 0, 0, 1))
        var step = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            if (step > 300) {
                return -1
            }
            for (i in 0 until size) {
                val item = queue.poll()
//                println("$step {${item[0]}, ${item[1]}, ${item[2]}, ${item[3]} }")

                if (item.joinToString(",") in set) {
                    continue
                }
                set.add(item.joinToString(","))
                if (item[0] == bottom && item[1] == right - 1 && item[2] == bottom && item[3] == right) {
                    return step
                }
                if (item[0] in 0..bottom && item[2] in 0..bottom
                        && item[1] in 0..right && item[3] in 0..right) {

                    // 1. go right
                    if (item[1] + 1 in 0..right && item[3] + 1 in 0..right
                            && grid[item[0]][item[1] + 1] == 0
                            && grid[item[2]][item[3] + 1] == 0) {
                        queue.offer(intArrayOf(item[0], item[1] + 1, item[2], item[3] + 1))
                    }
                    // 2. go down
                    if (item[0] + 1 in 0..bottom && item[2] + 1 in 0..bottom
                            && grid[item[0] + 1][item[1]] == 0
                            && grid[item[2] + 1][item[3]] == 0) {
                        queue.offer(intArrayOf(item[0] + 1, item[1], item[2] + 1, item[3]))
                    }

                    // 3. turn down
                    if (item[0] == item[2] && (item[2] + 1) in 0..bottom &&
                            grid[item[2] + 1][item[3]] == 0 && grid[item[0] + 1][item[1]] == 0) {
                        queue.offer(intArrayOf(item[0], item[1], item[0] + 1, item[1]))
                    }
                    // 4. turn right
                    if (item[1] == item[3] && (item[3] + 1) in 0..right &&
                            grid[item[2]][item[3] + 1] == 0 && grid[item[0]][item[1] + 1] == 0) {
                        queue.offer(intArrayOf(item[0], item[1], item[0], item[1] + 1))
                    }
                }
            }
            step++
        }
        return -1
    }
}