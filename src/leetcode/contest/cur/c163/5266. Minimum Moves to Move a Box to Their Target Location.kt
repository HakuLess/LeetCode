package leetcode.contest.cur.c163

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val s = Solution5266()
    s.minPushBox(arrayOf(
            charArrayOf('#', '#', '#', '#', '#', '#'),
            charArrayOf('#', 'T', '#', '#', '#', '#'),
            charArrayOf('#', '.', '.', 'B', '.', '#'),
            charArrayOf('#', '.', '#', '#', '.', '#'),
            charArrayOf('#', '.', '.', '.', 'S', '#'),
            charArrayOf('#', '#', '#', '#', '#', '#')
    )).print()

//    [
//        ["#","#","#","#","#","#"],
//        ["#","T","#","#","#","#"],
//        ["#",".",".","B",".","#"],
//        ["#","#","#","#",".","#"],
//        ["#",".",".",".","S","#"],
//        ["#","#","#","#","#","#"]
//    ]

//    [
//        ["#","#","#","#","#","#","#"],
//        ["#","S","#",".","B","T","#"],
//        ["#","#","#","#","#","#","#"]
//    ]

//    [
//        [".",".","#",".",".",".",".",".",".","."],
//        [".","#",".","#","B","#",".","#",".","."],
//        [".","#",".",".",".",".",".",".","T","."],
//        ["#",".",".",".",".",".",".",".",".","."],
//        [".",".",".",".",".",".",".",".",".","#"],
//        [".",".",".",".",".",".",".",".","#","."],
//        [".",".",".","#",".",".","#","#",".","."],
//        [".",".",".",".","#",".",".","#",".","."],
//        [".","#",".","S",".",".",".",".",".","."],
//        ["#",".",".","#",".",".",".",".",".","#"]
//    ]
}

class Solution5266 {
    var n = 0
    var m = 0
    val seen = HashSet<String>()
    val map = HashMap<String, Int>()

    fun minPushBox(grid: Array<CharArray>): Int {
        var ans = Int.MAX_VALUE
        val start = IntArray(5)
        n = grid.lastIndex
        m = grid[0].lastIndex
        var endX = 0
        var endY = 0
        for (i in 0..n) {
            for (j in 0..m) {
                if (grid[i][j] == 'S') {
                    start[2] = i
                    start[3] = j
                }
                if (grid[i][j] == 'B') {
                    start[0] = i
                    start[1] = j
                }
                if (grid[i][j] == 'T') {
                    endX = i
                    endY = j
                }
            }
        }

        start[4] = 0

        val queue: Queue<IntArray> = LinkedList<IntArray>()
        queue.add(start)
        var step = -1
        while (queue.isNotEmpty()) {
            val size = queue.size
            step++
            for (i in 0 until size) {
                val item = queue.poll()
                item.print()
                val key = item.slice(IntRange(0, item.lastIndex - 1)).joinToString(",")
                if (key in seen && map[key]!! <= item[4]) {
                    continue
                }
                seen.add(key)
                map[key] = item[4]
                if (item[0] == endX && item[1] == endY) {
                    ans = minOf(ans, item[4])
                }
                if (isValid(grid, item[2] + 1, item[3])) {
                    if (item[2] + 1 == item[0] && item[3] == item[1]) {
                        if (isValid(grid, item[0] + 1, item[1]))
                            queue.offer(intArrayOf(item[0] + 1, item[1], item[2] + 1, item[3], item[4] + 1))
                    } else {
                        queue.offer(intArrayOf(item[0], item[1], item[2] + 1, item[3], item[4]))
                    }
                }

                if (isValid(grid, item[2] - 1, item[3])) {
                    if (item[2] - 1 == item[0] && item[3] == item[1]) {
                        if (isValid(grid, item[0] - 1, item[1]))
                            queue.offer(intArrayOf(item[0] - 1, item[1], item[2] - 1, item[3], item[4] + 1))
                    } else {
                        queue.offer(intArrayOf(item[0], item[1], item[2] - 1, item[3], item[4]))
                    }
                }

                if (isValid(grid, item[2], item[3] + 1)) {
                    if (item[2] == item[0] && item[3] + 1 == item[1]) {
                        if (isValid(grid, item[0], item[1] + 1))
                            queue.offer(intArrayOf(item[0], item[1] + 1, item[2], item[3] + 1, item[4] + 1))
                    } else {
                        queue.offer(intArrayOf(item[0], item[1], item[2], item[3] + 1, item[4]))
                    }
                }

                if (isValid(grid, item[2], item[3] - 1)) {
                    if (item[2] == item[0] && item[3] - 1 == item[1]) {
                        if (isValid(grid, item[0], item[1] - 1))
                            queue.offer(intArrayOf(item[0], item[1] - 1, item[2], item[3] - 1, item[4] + 1))
                    } else {
                        queue.offer(intArrayOf(item[0], item[1], item[2], item[3] - 1, item[4]))
                    }
                }

            }
        }
        return if (ans == Int.MAX_VALUE) {
            -1
        } else {
            ans
        }
    }

    private fun isValid(grid: Array<CharArray>, i: Int, j: Int): Boolean {
        if (i !in 0..n) {
            return false
        }
        if (j !in 0..m) {
            return false
        }
        if (grid[i][j] == '#') {
            return false
        }
        return true
    }
}

//if (item[2] + 1 in 0..n) {
//    if (grid[item[2] + 1][item[3]] == '.') {
//        queue.offer(intArrayOf(item[0], item[1], item[2] + 1, item[3]))
//    }
//    if (item[2] + 1 == item[0] && item[3] == item[1]
//            && item[0] + 1 in 0..n && grid[item[0] + 1][item[1]] == '.') {
//        queue.offer(intArrayOf(item[0] + 1, item[1], item[2] + 1, item[3]))
//    }
//}