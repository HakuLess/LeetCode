package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val moves = "UD"
//    val moves = "LL"
    val s = Solution657()
    s.judgeCircle(moves).print()
}

class Solution657 {
    fun judgeCircle(moves: String): Boolean {
        var y = 0
        var x = 0
        moves.forEach {
            when (it) {
                'U' -> y--
                'D' -> y++
                'L' -> x--
                'R' -> x++
            }
        }
        return x == 0 && y == 0
    }
}