package leetcode.normal

import kotlin.math.max

fun smallestRangeI(A: IntArray, K: Int): Int {
    if (A.isEmpty()) {
        return 0
    }
    return max(0, A.max()!! - A.min()!! - 2 * K)
}