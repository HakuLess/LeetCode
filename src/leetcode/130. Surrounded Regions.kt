package leetcode

import java.util.*

class Solution130 {
    fun solve(board: Array<CharArray>): Unit {
        if (board.isEmpty() || board[0].isEmpty()) {
            return
        }

        val x = board.size
        val y = board[0].size

        val lo = arrayListOf<Pair<Int, Int>>()
        for (i in 0 until x) {
            for (j in 0 until y) {
                if (board[i][j] == 'O') {
                    lo.add(Pair(i, j))
                }
            }
        }

        val queue: Queue<Pair<Int, Int>> = LinkedList()
        lo.filter {
            it.first == 0 || it.first == x - 1 || it.second == 0 || it.second == y - 1
        }.forEach {
            queue.offer(it)
        }

        while (queue.isNotEmpty()) {
            val item = queue.poll()
            if (item in lo) {
                lo.remove(item)
                queue.add(Pair(item.first + 1, item.second))
                queue.add(Pair(item.first - 1, item.second))
                queue.add(Pair(item.first, item.second + 1))
                queue.add(Pair(item.first, item.second - 1))
            }
        }

        lo.forEach {
            board[it.first][it.second] = 'X'
        }
    }
}