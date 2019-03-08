package leetcode

class Solution915 {
    fun partitionDisjoint(A: IntArray): Int {
        val n = A.size
        val maxLeft = IntArray(n)
        val minRight = IntArray(n)

        var m = A[0]
        for (i in 0 until n) {
            m = maxOf(m, A[i])
            maxLeft[i] = m
        }

        m = A[n - 1]
        for (i in n - 1 downTo 0) {
            m = minOf(m, A[i])
            minRight[i] = m
        }

        for (i in 1 until n)
            if (maxLeft[i - 1] <= minRight[i])
                return i

        return 0
    }
}