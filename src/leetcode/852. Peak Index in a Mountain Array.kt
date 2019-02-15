package leetcode

fun peakIndexInMountainArray(A: IntArray): Int {
    for (i in 0 until A.size - 1) {
        println("$i ${A[i]} ${A[i + 1]}")
        if (A[i] > A[i + 1]) {
            return i
        }
    }
    return 0
}