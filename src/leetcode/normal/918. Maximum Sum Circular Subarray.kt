package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution918()
    s.maxSubarraySumCircular(
            intArrayOf(1, -2, 3, -2)
    ).print()
    s.maxSubarraySumCircular(
            intArrayOf(5, -3, 5)
    ).print()
    s.maxSubarraySumCircular(
            intArrayOf(3, -1, 2, -1)
    ).print()
    s.maxSubarraySumCircular(
            intArrayOf(3, -2, 2, -3)
    ).print()
    s.maxSubarraySumCircular(
            intArrayOf(-2, -3, -1)
    ).print()
}

class Solution918 {
    fun maxSubarraySumCircular(A: IntArray): Int {
        val b = IntArray(A.size * 2)
        for (i in 0 until b.size) {
            b[i] = A[i % A.size]
        }
        var result = Int.MIN_VALUE
        for (i in 0 until A.size) {
            var temp = 0
            for (j in 0 until A.size) {
                temp += b[i + j]
                result = maxOf(result, temp)
            }
        }
        return result
    }
}