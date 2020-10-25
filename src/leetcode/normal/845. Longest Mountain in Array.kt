package leetcode.normal

class Solution845 {
    fun longestMountain(A: IntArray): Int {
        val n: Int = A.size
        if (n == 0) {
            return 0
        }
        val left = IntArray(n)
        for (i in 1 until n) {
            left[i] = if (A[i - 1] < A[i]) left[i - 1] + 1 else 0
        }
        val right = IntArray(n)
        for (i in n - 2 downTo 0) {
            right[i] = if (A[i + 1] < A[i]) right[i + 1] + 1 else 0
        }
        var ans = 0
        for (i in 0 until n) {
            if (left[i] > 0 && right[i] > 0) {
                ans = maxOf(ans, left[i] + right[i] + 1)
            }
        }
        return ans
    }
}