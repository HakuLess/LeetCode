package leetcode.contest.last.b03

class Solution1099 {
    fun twoSumLessThanK(A: IntArray, K: Int): Int {
        var cur = -1
        for (i in 0 until A.size - 1) {
            for (j in i + 1 until A.size) {
                if (A[i] + A[j] in (cur + 1) until K) {
                    cur = A[i] + A[j]
                }
            }
        }
        return cur
    }
}