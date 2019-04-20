package leetcode.normal

import kotlin.math.max
import kotlin.math.min

fun smallestRangeII(A: IntArray, K: Int): Int {
    if (A.isEmpty()) {
        return 0
    }
    A.sort()

    var result = A.last() - A.first()
    for (i in 0 until A.size - 1) {
        val high = max(A.last() - K, A[i] + K)
        val low = min(A.first() + K, A[i + 1] - K)
        result = min(result, high - low)
    }

    return result
}