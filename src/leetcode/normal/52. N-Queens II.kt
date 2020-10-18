package leetcode.normal

class Solution52 {
    var N = 0
    var ans = 0
    fun totalNQueens(n: Int): Int {
        N = n
        val board = Array(n) { CharArray(n) { '.' } }
        solveNQUtil(board, 0)
        return ans
    }

    private fun isSafe(board: Array<CharArray>, row: Int, col: Int): Boolean {
        var i: Int = 0
        var j: Int = col
        while (i < col) {
            if (board[row][i] == 'Q')
                return false
            i++
        }
        i = row
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q')
                return false
            i--
            j--
        }
        i = row
        j = col
        while (j >= 0 && i < N) {
            if (board[i][j] == 'Q')
                return false
            i++
            j--
        }
        return true
    }

    private fun solveNQUtil(board: Array<CharArray>, col: Int) {
        if (col >= N) {
            ans++
            return
        }
        for (i in 0 until N) {
            if (isSafe(board, i, col)) {
                board[i][col] = 'Q'
                solveNQUtil(board, col + 1)
                board[i][col] = '.'
            }
        }
    }
}