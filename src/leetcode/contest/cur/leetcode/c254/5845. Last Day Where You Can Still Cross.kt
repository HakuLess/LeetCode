package leetcode.contest.cur.leetcode.c254

import java.util.*

class Solution5845 {
    fun latestDayToCross(row: Int, col: Int, cells: Array<IntArray>): Int {
        val dir4 = arrayOf(
                intArrayOf(0, 1),
                intArrayOf(0, -1),
                intArrayOf(1, 0),
                intArrayOf(-1, 0)
        )

        fun check(mid: Int): Boolean {
            val block = Array<BooleanArray>(row) { BooleanArray(col) }
            for (i in 0 until mid) {
                block[cells[i][0] - 1][cells[i][1] - 1] = true
            }

            val seen = Array<BooleanArray>(row) { BooleanArray(col) }
            val queue: Queue<IntArray> = LinkedList<IntArray>()
            for (j in 0 until col) {
                if (!block[0][j]) {
                    queue.offer(intArrayOf(0, j))
                    seen[0][j] = true
                }
            }
            while (queue.isNotEmpty()) {
                val size = queue.size
                for (i in 0 until size) {
                    val item = queue.poll()
                    if (item[0] == row - 1) {
                        return true
                    }
                    dir4.forEach {
                        val next = intArrayOf(item[0] + it[0], item[1] + it[1])
                        if (next[0] in 0 until row
                                && next[1] in 0 until col
                                && !block[next[0]][next[1]]
                                && !seen[next[0]][next[1]]) {
                            queue.offer(next)
                            seen[next[0]][next[1]] = true
                        }
                    }
                }
            }
            return false
        }

        var left = 0
        var right = cells.lastIndex
        while (left + 1 < right) {
            val mid = (left + right).ushr(1)
            when {
                check(mid) -> left = mid
                else -> right = mid
            }
        }
        return if (check(right)) {
            right
        } else {
            left
        }
    }
}