package leetcode.contest.last.c167

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5286()
    s.shortestPath(
            arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(1, 1, 0),
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 1),
                    intArrayOf(0, 0, 0)
            ), 1
    ).print()

    s.shortestPath(
            arrayOf(
                    intArrayOf(0, 0, 1, 0, 0),
                    intArrayOf(0, 1, 0, 1, 0)
            ), 2
    ).print()
}

class Solution5286 {
    fun shortestPath(grid: Array<IntArray>, k: Int): Int {
        var ans = -1
        val queue: Queue<State> = LinkedList<State>()
        val state = State()
        state.k = k
        queue.add(state)
        var t = -1
        val seen = hashSetOf<String>()
        while (queue.isNotEmpty()) {
            val size = queue.size
            t++
            if (t > 200) {
                return -1
            }
            for (i in 0 until size) {
                val item = queue.poll()
                item.toString().print()
                if (item.toString() in seen) {
                    continue
                } else {
                    seen.add(item.toString())
                }
                if (item.x == grid.lastIndex && item.y == grid[0].lastIndex) {
                    return t
                }
                if (item.x + 1 in 0..grid.lastIndex) {
                    val new = State()
                    new.x = item.x + 1
                    new.y = item.y
                    if (grid[new.x][new.y] == 1) {
                        new.k = item.k - 1
                    } else {
                        new.k = item.k
                    }
                    if (new.k >= 0) {
                        queue.add(new)
                    }
                }

                if (item.x - 1 in 0..grid.lastIndex) {
                    val new = State()
                    new.x = item.x - 1
                    new.y = item.y
                    if (grid[new.x][new.y] == 1) {
                        new.k = item.k - 1
                    } else {
                        new.k = item.k
                    }
                    if (new.k >= 0) {
                        queue.add(new)
                    }
                }

                if (item.y - 1 in 0..grid[0].lastIndex) {
                    val new = State()
                    new.x = item.x
                    new.y = item.y - 1
                    if (grid[new.x][new.y] == 1) {
                        new.k = item.k - 1
                    } else {
                        new.k = item.k
                    }
                    if (new.k >= 0) {
                        queue.add(new)
                    }
                }

                if (item.y + 1 in 0..grid[0].lastIndex) {
                    val new = State()
                    new.x = item.x
                    new.y = item.y + 1
                    if (grid[new.x][new.y] == 1) {
                        new.k = item.k - 1
                    } else {
                        new.k = item.k
                    }
                    if (new.k >= 0) {
                        queue.add(new)
                    }
                }
            }

        }
        return ans
    }

    class State {
        var x: Int = 0
        var y: Int = 0
        var k: Int = 0

        override fun toString(): String {
            return "$x, $y, $k"
        }
    }
}

