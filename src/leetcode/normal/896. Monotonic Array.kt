package leetcode.normal

class Solution896 {
    fun isMonotonic(A: IntArray): Boolean {
        if (A.size <= 2) {
            return true
        }

        var increase: Boolean? = null
        for (i in 1 until A.size) {
            if (A[i] == A[i - 1]) {
                continue
            } else if (A[i] > A[i - 1]) {
                if (increase == null) {
                    increase = true
                } else if (increase == false) {
                    return false
                }
            } else {
                if (increase == null) {
                    increase = false
                } else if (increase == true) {
                    return false
                }
            }
        }
        return true
    }
}