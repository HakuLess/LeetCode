package leetcode.normal

fun largestPerimeter(A: IntArray): Int {
    A.sortDescending()
    for (i in 0 until A.size - 2) {
        if (A[i] < A[i + 1] + A[i + 2]) {
            return A[i + 1] + A[i + 2] + A[i]
        }
    }

    return 0
}