package leetcode.contest.c135

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution5047()
    s.minScoreTriangulation(
            intArrayOf(1, 2, 4, 4)
    ).print()
//    s.minScoreTriangulation(
//            intArrayOf(3, 7, 4, 5)
//    ).print()
//
//    s.minScoreTriangulation(
//            intArrayOf(1, 3, 1, 1, 4, 5)
//    ).print()
}

class Solution5047 {
    fun minScoreTriangulation(A: IntArray): Int {
        A.sort()
        val n = A.size - 2
        var ans = 0
        for (i in 0 until n) {
            val min0 = A[i / 2]
            val min1 = A[i / 2 + 1]
            val max = A[A.lastIndex - i]
            println("$min0, $min1, $max")
            ans += min0 * min1 * max
        }
        return ans
    }
}