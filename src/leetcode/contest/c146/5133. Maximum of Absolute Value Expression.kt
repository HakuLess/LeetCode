package leetcode.contest.c146

import kotlin.math.abs

class Solution5133 {
    fun maxAbsValExpr(arr1: IntArray, arr2: IntArray): Int {
        val size = arr1.size
        var ans = 0
        for (i in 0 until size - 1) {
            for (j in i + 1 until size) {
                ans = maxOf(
                        ans,
                        abs(arr1[i] - arr1[j]) + abs(arr2[i] - arr2[j]) + abs(i - j)
                )
            }
        }
        return ans
    }
}