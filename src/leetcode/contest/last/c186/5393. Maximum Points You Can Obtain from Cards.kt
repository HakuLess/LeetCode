package leetcode.contest.last.c186

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5393()
    s.maxScore(intArrayOf(1, 2, 3, 4, 5, 6, 1), 3).print()
//    s.maxScore(intArrayOf(2, 2, 2), 2).print()
//    s.maxScore(intArrayOf(9, 7, 7, 9, 7, 7, 9), 7).print()
//    s.maxScore(intArrayOf(1, 1000, 1), 1).print()
//    s.maxScore(intArrayOf(1, 79, 80, 1, 1, 1, 200, 1), 3).print()
//    s.maxScore(intArrayOf(96, 90, 41, 82, 39, 74, 64, 50, 30), 8).print()
}

class Solution5393 {
    fun maxScore(cardPoints: IntArray, k: Int): Int {
        val l = cardPoints.size - k
        var cur = 0
        for (i in 0 until l) {
            cur += cardPoints[i]
        }
        var ans = cur
        for (i in l until cardPoints.size) {
            cur += cardPoints[i]
            cur -= cardPoints[i - l]
            ans = minOf(cur, ans)
        }
        return cardPoints.sum() - ans
    }
}