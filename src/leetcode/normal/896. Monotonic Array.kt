package leetcode.normal

class Solution896 {
    fun isMonotonic(A: IntArray): Boolean {
        var inc: Boolean? = null
        for (i in 1 until A.size) {
            if (A[i] == A[i - 1]) {
                continue
            } else if (inc == null || inc == A[i] > A[i - 1]) {
                inc = A[i] > A[i - 1]
            } else {
                return false
            }
        }
        return true
    }
}