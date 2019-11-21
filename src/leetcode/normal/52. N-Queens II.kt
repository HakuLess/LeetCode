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

    /* A utility function to check if a queen can
       be placed on board[row][col]. Note that this
       function is called when "col" queens are already
       placed in columns from 0 to col -1. So we need
       to check only left side for attacking queens */
    private fun isSafe(board: Array<CharArray>, row: Int, col: Int): Boolean {
        var i: Int = 0
        var j: Int = col

        /* Check this row on left side */
        while (i < col) {
            if (board[row][i] == 'Q')
                return false
            i++
        }

        /* Check upper diagonal on left side */
        i = row
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q')
                return false
            i--
            j--
        }

        /* Check lower diagonal on left side */
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

    /* A recursive utility function to solve N Queen problem */
    private fun solveNQUtil(board: Array<CharArray>, col: Int) {
        /* base case: If all queens are placed then return true */
        if (col >= N) {
            ans++
            return
        }

        /* Consider this column and try placing this queen in all rows one by one */
        for (i in 0 until N) {
            /* Check if the queen can be placed on board[i][col] */
            if (isSafe(board, i, col)) {
                /* Place this queen in board[i][col] */
                board[i][col] = 'Q'

                /* recur to place rest of the queens */
                solveNQUtil(board, col + 1)

                /* If placing queen in board[i][col]
                   doesn't lead to a solution then
                   remove queen from board[i][col] */
                // BACKTRACK
                board[i][col] = '.'
            }
        }
    }
}