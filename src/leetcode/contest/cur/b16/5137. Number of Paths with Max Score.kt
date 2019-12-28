package leetcode.contest.cur.b16

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5137()
    s.pathsWithMaxScore(listOf("E23", "2X2", "12S")).print()
    s.pathsWithMaxScore(listOf("E12", "1X1", "21S")).print()
    s.pathsWithMaxScore(listOf("E11", "XXX", "11S")).print()
    s.pathsWithMaxScore(listOf("EX", "XS")).print()
}

class Solution5137 {
    fun pathsWithMaxScore(board: List<String>): IntArray {
        val mod = 1000000007
        val dp = Array<Array<Pair<Int, Int>>>(board.size) { Array(board[0].length) { Pair(0, 0) } }
        for (i in 0..dp.lastIndex) {
            for (j in 0..dp[0].lastIndex) {
                if (board[i][j] == 'X') {
                    dp[i][j] = Pair(-1, 0)
                    continue
                }

                if (i == 0 && j == 0) {
                    dp[i][j] = Pair(0, 1)
                } else if (i == 0) {
                    if (board[i][j] != 'X') {
                        if (dp[i][j - 1].first == -1) {
                            dp[i][j] = Pair(-1, 0)
                        } else {
                            dp[i][j] = Pair(dp[i][j - 1].first + (board[i][j] - '0'), 1)
                        }
                    }
                } else if (j == 0) {
                    if (board[i][j] != 'X') {
                        if (dp[i - 1][j].first == -1) {
                            dp[i][j] = Pair(-1, 0)
                        } else {
                            dp[i][j] = Pair(dp[i - 1][j].first + (board[i][j] - '0'), 1)
                        }
                    }
                } else {
                    if (board[i][j] == 'X') {
                        dp[i][j] = Pair(-1, 0)
                        continue
                    }
                    val v0 = dp[i - 1][j - 1]
                    val v1 = dp[i - 1][j]
                    val v2 = dp[i][j - 1]

                    val max = listOf(v0, v1, v2).maxBy { it.first }!!.first
                    var sec = 0
                    var fir = 0
                    listOf(v0, v1, v2).filter {
                        it.first == max
                    }.forEach {
                        sec += it.second
                        sec %= mod
                        fir = it.first
                    }
                    if (board[i][j] != 'S')
                        dp[i][j] = Pair(fir + (board[i][j] - '0'), sec % mod)
                    else
                        dp[i][j] = Pair(fir, sec)
                }
            }
        }
//        dp.forEach {
//            it.forEach {
//                print(it)
//                print("  -  ")
//            }
//            println()
//        }
        return intArrayOf(if (dp.last().last().first == -1) 0 else dp.last().last().first, dp.last().last().second)
    }
}