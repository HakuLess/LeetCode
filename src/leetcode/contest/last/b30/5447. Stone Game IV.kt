package leetcode.contest.last.b30

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5447()
    s.winnerSquareGame(1).print()
//    s.winnerSquareGame(17).print()
//    s.winnerSquareGame(8).print()
//    s.winnerSquareGame(99999).print()
//    s.winnerSquareGame(92719).print()
}

// DP
class Solution5447 {
    fun winnerSquareGame(n: Int): Boolean {
        val sq = arrayListOf<Int>()
        for (i in 1 until 350) {
            sq.add(i * i)
        }
        val dp = BooleanArray(n + 1) { false }
        for (i in 1..n) {
            sq.forEach {
                if (it <= i) {
                    if (!dp[i - it]) {
                        dp[i] = true
                        return@forEach
                    }
                } else {
                    return@forEach
                }
            }
        }
        return dp[n]
    }
}