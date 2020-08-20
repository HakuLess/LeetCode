package leetcode.normal

class Solution529 {

    var dirX = intArrayOf(0, 1, 0, -1, 1, 1, -1, -1)
    var dirY = intArrayOf(1, 0, -1, 0, 1, -1, 1, -1)

    fun updateBoard(board: Array<CharArray>, click: IntArray): Array<CharArray>? {
        val x = click[0]
        val y = click[1]
        if (board[x][y] == 'M') {
            board[x][y] = 'X'
        } else {
            dfs(board, x, y)
        }
        return board
    }

    fun dfs(board: Array<CharArray>, x: Int, y: Int) {
        var cnt = 0
        for (i in 0..7) {
            val tx = x + dirX[i]
            val ty = y + dirY[i]
            if (tx !in board.indices || ty !in board[0].indices) {
                continue
            }
            if (board[tx][ty] == 'M') {
                ++cnt
            }
        }
        if (cnt > 0) {
            board[x][y] = (cnt + '0'.toInt()).toChar()
        } else {
            board[x][y] = 'B'
            for (i in 0..7) {
                val tx = x + dirX[i]
                val ty = y + dirY[i]
                if (tx !in board.indices || ty !in board[0].indices || board[tx][ty] != 'E') {
                    continue
                }
                dfs(board, tx, ty)
            }
        }
    }
}