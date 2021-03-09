package leetcode.normal

import leetcode.contest.utils.print
import java.util.*


fun main(args: Array<String>) {
    val s = Solution132()
    s.minCut("ababababababababababababcbabababababababababababa").print()
}

class Solution132 {
    fun minCut(s: String): Int {
        val n = s.length
        val g = Array(n) { BooleanArray(n) { true } }
        for (i in n - 1 downTo 0) {
            for (j in i + 1 until n) {
                g[i][j] = s[i] == s[j] && g[i + 1][j - 1]
            }
        }
        val dp = IntArray(n) { Int.MAX_VALUE }
        for (i in 0 until n) {
            if (g[0][i]) {
                dp[i] = 0
            } else {
                for (j in 0 until i) {
                    if (g[j + 1][i]) {
                        dp[i] = minOf(dp[i], dp[j] + 1)
                    }
                }
            }
        }
        return dp[n - 1]
    }

//    fun minCut(s: String): Int {
//        val n = s.length
//        val pal = Array<IntArray>(n) { IntArray(n) { Int.MAX_VALUE / 2 } }
//        for (i in s.indices) {
//            for (j in i until n) {
//                val str = s.substring(i, j + 1)
//                if (str == str.reversed()) {
//                    pal[i][j] = 1
//                }
//            }
//        }
//        val dp = IntArray(n) { Int.MAX_VALUE / 2 }
//        for (i in s.indices) {
//            if (pal[0][i] == 1) {
//                dp[i] = 0
//                continue
//            }
//            for (j in 0 until i) {
//                if (pal[j + 1][i] == 1)
//                    dp[i] = minOf(dp[j] + 1, dp[i])
//            }
//        }
//        return dp[n - 1]
//    }
}