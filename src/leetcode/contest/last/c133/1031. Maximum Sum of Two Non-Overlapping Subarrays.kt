package leetcode.contest.last.c133

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution1031()
    s.maxSumTwoNoOverlap(intArrayOf(0, 6, 5, 2, 2, 5, 1, 9, 4), 1, 2).print()
    s.maxSumTwoNoOverlap(intArrayOf(3, 8, 1, 3, 2, 1, 8, 9, 0), 3, 2).print()
    s.maxSumTwoNoOverlap(intArrayOf(2, 1, 5, 6, 0, 9, 5, 0, 3, 8), 4, 3).print()
}

class Solution1031 {
    fun maxSumTwoNoOverlap(A: IntArray, L: Int, M: Int): Int {
        return maxOf(getMax(A, L, M), getMax(A, M, L))
    }

    private fun getMax(A: IntArray, L: Int, M: Int): Int {
        var max = 0
        val size = A.size

        for (i in 0..size - M - L) {
            for (j in i + L..size - M) {
                var ans = 0
                for (left in i until i + L) {
                    ans += A[left]
                }

                for (right in j until j + M) {
                    ans += A[right]
                }
//                println("$i, $j, $ans")
                max = maxOf(max, ans)
            }
        }

        return max
    }
}