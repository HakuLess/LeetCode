package leetcode.contest.cur.mst

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution46()
    s.translateNum(12258).print()
    s.translateNum(25).print()
}

class Solution46 {
    fun translateNum(num: Int): Int {
        val s = num.toString()
        val n = s.length
        val dp = IntArray(n + 1)
        dp[0] = 1
        dp[1] = 1
        for (i in 2..n) {
            val v = s.substring(i - 2, i).toInt()
            if (v in 10..25) {
                dp[i] = dp[i - 1] + dp[i - 2]
            } else {
                dp[i] = dp[i - 1]
            }
        }
        return dp[n]
    }

//    fun translateNum(num: Int): Int {
//        return helper(num.toString())
//    }
//
//    private fun helper(str: String): Int {
//        if (str.isEmpty()) {
//            return 0
//        }
//        if (str.length == 1) {
//            return 1
//        }
//        if (str.startsWith('0')) {
//            return helper(str.substring(1, str.length))
//        }
//        if (str.length == 2) {
//            return if (str.toInt() in 10..25) {
//                2
//            } else {
//                1
//            }
//        }
//        if (str.substring(0, 2).toInt() in 10..25) {
//            return helper(str.substring(1, str.length)) + helper(str.substring(2, str.length))
//        }
//        return helper(str.substring(1, str.length))
//    }
}