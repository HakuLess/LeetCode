package leetcode.contest.last.b58

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5827()
    s.checkMove(
        arrayOf(
            arrayOf('.', '.', '.', 'B', '.', '.', '.', '.').toCharArray(),
            arrayOf('.', '.', '.', 'W', '.', '.', '.', '.').toCharArray(),
            arrayOf('.', '.', '.', 'W', '.', '.', '.', '.').toCharArray(),
            arrayOf('.', '.', '.', 'W', '.', '.', '.', '.').toCharArray(),
            arrayOf('W', 'B', 'B', '.', 'W', 'W', 'W', 'B').toCharArray(),
            arrayOf('.', '.', '.', 'B', '.', '.', '.', '.').toCharArray(),
            arrayOf('.', '.', '.', 'B', '.', '.', '.', '.').toCharArray(),
            arrayOf('.', '.', '.', 'W', '.', '.', '.', '.').toCharArray()
        ), 4, 3, 'B'
    ).print()
}

class Solution5827 {
    fun checkMove(board: Array<CharArray>, rMove: Int, cMove: Int, color: Char): Boolean {
        val dir8 = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 1),
            intArrayOf(-1, 1),
            intArrayOf(0, -1),
            intArrayOf(1, -1),
            intArrayOf(-1, -1),
            intArrayOf(1, 0),
            intArrayOf(-1, 0)
        )

        fun dfs(it: Int): Boolean {
            val ori = dir8[it]
            var r = rMove
            var c = cMove
            var seen = false
            while (r + ori[0] in 0..7 && c + ori[1] in 0..7) {
                r += ori[0]
                c += ori[1]
//                println("$r $c")
                when (board[r][c]) {
                    '.' -> return false
                    color -> return seen
                    else -> seen = true
                }
            }
            return false
        }

        repeat(8) {
            if (dfs(it)) return true
        }
        return false
    }
}