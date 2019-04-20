package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution1021()
    s.maxScoreSightseeingPair(
            intArrayOf(8, 1, 5, 2, 6)
    ).print()
}

class Solution1021 {
    fun maxScoreSightseeingPair(A: IntArray): Int {
        var max = 0
        for (i in 0 until A.size - 1) {
            for (j in i + 1 until A.size) {
                max = maxOf(A[j] + A[i] + i - j, max)
            }
        }
        return max
    }
}