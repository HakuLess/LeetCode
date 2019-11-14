package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution37()
    s.solveSudoku(arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '4'),
            charArrayOf('.', '.', '.', '4', '1', '9', '6', '3', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '1', '7', '9')
    ))
}

class Solution37 {
    fun solveSudoku(board: Array<CharArray>) {
        val row = Array(9) { BooleanArray(10) }
        val col = Array(9) { BooleanArray(10) }
        val block = Array(9) { BooleanArray(10) }

        for (i in 0..8) {
            for (j in 0..8) {
                if (board[i][j] != '.') {
                    val num = board[i][j] - '0'
                    row[i][num] = true
                    col[j][num] = true
                    block[i / 3 * 3 + j / 3][num] = true
                }
            }
        }
        dfs(board, row, col, block, 0, 0)
        board.print()
    }

    private fun dfs(board: Array<CharArray>, row: Array<BooleanArray>, col: Array<BooleanArray>, block: Array<BooleanArray>, x: Int, y: Int): Boolean {
        var i = x
        var j = y
        // Find the blank
        while (board[i][j] != '.') {
            if (++j >= 9) {
                i++
                j = 0
            }
            if (i >= 9) {
                return true
            }
        }
        for (num in 1..9) {
            val blockIndex = i / 3 * 3 + j / 3
            if (!row[i][num] && !col[j][num] && !block[blockIndex][num]) {
                board[i][j] = '0' + num
                row[i][num] = true
                col[j][num] = true
                block[blockIndex][num] = true
                if (dfs(board, row, col, block, i, j)) {
                    return true
                } else {
                    // 回溯
                    row[i][num] = false
                    col[j][num] = false
                    block[blockIndex][num] = false
                    board[i][j] = '.'
                }
            }
        }
        return false
    }
}