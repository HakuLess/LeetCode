package leetcode.normal

import kotlin.math.abs

class Solution289 {
    fun gameOfLife(board: Array<IntArray>): Unit {
        val neighbors = intArrayOf(0, 1, -1)
        val rows: Int = board.size
        val cols: Int = board[0].size
        for (row in 0 until rows) {
            for (col in 0 until cols) {
                var liveNeighbors = 0
                for (i in 0..2) {
                    for (j in 0..2) {
                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            val r = row + neighbors[i]
                            val c = col + neighbors[j]
                            if (r in 0 until rows && c < cols && c >= 0 && abs(board[r][c]) == 1) {
                                liveNeighbors += 1
                            }
                        }
                    }
                }
                if (board[row][col] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[row][col] = -1
                }
                if (board[row][col] == 0 && liveNeighbors == 3) {
                    board[row][col] = 2
                }
            }
        }
        for (row in 0 until rows) {
            for (col in 0 until cols) {
                if (board[row][col] > 0) {
                    board[row][col] = 1
                } else {
                    board[row][col] = 0
                }
            }
        }
    }
}