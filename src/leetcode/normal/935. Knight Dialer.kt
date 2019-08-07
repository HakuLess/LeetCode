package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution935()
//    s.knightDialer(1).print()
//    s.knightDialer(2).print()
//    s.knightDialer(3333).print()
    s.knightDialer(171).print()
}

class Solution935 {

//    private val MOVES = arrayOf(intArrayOf(4, 6), intArrayOf(6, 8), intArrayOf(7, 9), intArrayOf(4, 8), intArrayOf(3, 9, 0), intArrayOf(), intArrayOf(1, 7, 0), intArrayOf(2, 6), intArrayOf(1, 3), intArrayOf(2, 4))
//    private val MOD = 1000000007
//
//    fun knightDialer(n: Int): Int {
//        val dp = Array(n) { LongArray(10) }
//        var result: Long = 0
//
//        for (i in 0 until n) {
//            for (j in 0..9) {
//                if (i == 0) {
//                    dp[i][j] = 1
//                    continue
//                }
//                for (move in MOVES[j]) {
//                    dp[i][j] += dp[i - 1][move] % MOD
//                }
//            }
//        }
//
//        for (j in 0..9) {
//            result += dp[n - 1][j]
//        }
//
//        return (result % MOD).toInt()
//    }

    fun knightDialer(N: Int): Int {
        val mod = 1000000007
        val count = Array(N) { IntArray(10) { 1 } }
        for (i in 1 until N) {
            count[i][0] = count[i - 1][6] + count[i - 1][4]
            count[i][0] = (count[i][0] % mod)
            count[i][1] = count[i - 1][6] + count[i - 1][8]
            count[i][1] = (count[i][1] % mod)
            count[i][2] = count[i - 1][7] + count[i - 1][9]
            count[i][2] = (count[i][2] % mod)
            count[i][3] = count[i - 1][4] + count[i - 1][8]
            count[i][3] = (count[i][3] % mod)
            count[i][4] = count[i - 1][3] + count[i - 1][0]
            count[i][4] = (count[i][4] % mod)
            count[i][4] += count[i - 1][9]
            count[i][4] = (count[i][4] % mod)
            count[i][5] = 0
            count[i][6] = count[i - 1][1] + count[i - 1][7]
            count[i][6] = (count[i][6] % mod)
            count[i][6] += count[i - 1][0]
            count[i][6] = (count[i][6] % mod)
            count[i][7] = count[i - 1][6] + count[i - 1][2]
            count[i][7] = (count[i][7] % mod)
            count[i][8] = count[i - 1][1] + count[i - 1][3]
            count[i][8] = (count[i][8] % mod)
            count[i][9] = count[i - 1][2] + count[i - 1][4]
            count[i][9] = (count[i][9] % mod)
        }

        var ans = 0L
        for (i in 0..9) {
            ans += (count[N - 1][i] % mod)
        }
        return (ans % mod).toInt()
    }
}