package leetcode.normal

class Solution888 {
    fun fairCandySwap(A: IntArray, B: IntArray): IntArray {
        val a = A.sum()
        val b = B.sum()
        val diff = (b - a) / 2
        for (i in A.indices) {
            if ((A[i] + diff) in B) {
                return intArrayOf(A[i], A[i] + diff)
            }
        }
        return intArrayOf()
    }
}