package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution1024()
    s.videoStitching(arrayOf(
            intArrayOf(0, 2),
            intArrayOf(4, 6),
            intArrayOf(8, 10),
            intArrayOf(1, 9),
            intArrayOf(1, 5),
            intArrayOf(5, 9)
    ), 10).print()
}

class Solution1024 {
    fun videoStitching(clips: Array<IntArray>, T: Int): Int {
        val dp = IntArray(T + 1) { Int.MAX_VALUE / 2 }
        dp[0] = 0
        for (i in 1..T) {
            clips.forEach {
                if (it[0] < i && i <= it[1]) {
                    dp[i] = minOf(dp[i], dp[it[0]] + 1)
                }
            }
        }
        return if (dp[T] == Int.MAX_VALUE / 2) -1 else dp[T]
    }
}