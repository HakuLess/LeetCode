package leetcode.normal

fun main(args: Array<String>) {
    val s = Solution51()
    s.solveNQueens(5).forEach {
        it.forEach {
            println(it)
        }
        println()
    }
}

class Solution51 {
    var N = 0
    val ans = arrayListOf<List<String>>()
    fun solveNQueens(n: Int): List<List<String>> {
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
            ans.add(board.map {
                it.joinToString("")
            })
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