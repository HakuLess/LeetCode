package leetcode.normal

class Solution908 {
    fun smallestRangeI(A: IntArray, K: Int): Int {
        if (A.isEmpty()) {
            return 0
        }
        return maxOf(0, A.maxOrNull()!! - A.minOrNull()!! - 2 * K)
    }
}