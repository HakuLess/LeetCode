package leetcode.normal


class Solution999 {
    fun numRookCaptures(board: Array<CharArray>): Int {
        var cnt = 0
        var st = 0
        var ed = 0
        val dx = intArrayOf(0, 1, 0, -1)
        val dy = intArrayOf(1, 0, -1, 0)
        for (i in 0..7) {
            for (j in 0..7) {
                if (board[i][j] == 'R') {
                    st = i
                    ed = j
                    break
                }
            }
        }
        for (i in 0..3) {
            var step = 0
            while (true) {
                val tx = st + step * dx[i]
                val ty = ed + step * dy[i]
                if (tx < 0 || tx >= 8 || ty < 0 || ty >= 8 || board[tx][ty] == 'B') {
                    break
                }
                if (board[tx][ty] == 'p') {
                    cnt++
                    break
                }
                ++step
            }
        }
        return cnt
    }
}