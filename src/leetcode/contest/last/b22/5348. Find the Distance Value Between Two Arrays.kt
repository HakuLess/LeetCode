package leetcode.contest.last.b22

import kotlin.math.abs

class Solution5348 {
    fun findTheDistanceValue(arr1: IntArray, arr2: IntArray, d: Int): Int {
        return arr1.count {
            arr2.all { a2 ->
                abs(a2 - it) > d
            }
        }
    }
}