package leetcode

fun repeatedNTimes(A: IntArray): Int {
    A.sort()
    for (i in 0 until A.size - 1) {
        if (A[i] == A[i + 1]) {
            return A[i]
        }
    }
    return 0
}