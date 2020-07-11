package leetcode.contest.cur.leetcode.b30

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5447()
    s.winnerSquareGame(1).print()
//    s.winnerSquareGame(17).print()
//    s.winnerSquareGame(8).print()
//    s.winnerSquareGame(99999).print()
//    s.winnerSquareGame(92719).print()
}

class Solution5447 {
    fun winnerSquareGame(n: Int): Boolean {
        val sq = arrayListOf<Int>()
        for (i in 1 until 400) {
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
        dp.print()
        return dp[n]
    }

//    val seen = HashMap<Int, Boolean>()
//
//    fun winnerSquareGame(n: Int): Boolean {
//        val sq = arrayListOf<Int>()
//        for (i in 1 until 400) {
//            sq.add(i * i)
//            seen[i * i] = true
//        }
//        return dfs(sq, n)
//    }
//
//    private fun dfs(sq: ArrayList<Int>, cur: Int): Boolean {
//        if (cur in seen) {
//            println("seen $cur ${seen[cur]}")
//            return seen[cur]!!
//        }
//        var ans = false
//        sq.forEach {
//            if (cur >= it) {
//                ans = ans or !dfs(sq, cur - it)
//            }
//        }
//        seen[cur] = ans
//        println("$cur, $ans")
//        return ans
//    }
}