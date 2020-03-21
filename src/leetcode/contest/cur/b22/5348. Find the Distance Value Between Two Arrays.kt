package leetcode.contest.cur.b22

import kotlin.math.abs

class Solution5348 {
    fun findTheDistanceValue(arr1: IntArray, arr2: IntArray, d: Int): Int {
        var ans = 0
        arr1.forEach { a1 ->
            if (arr2.all { a2 ->
                        abs(a2 - a1) > d
                    }) ans++
        }
        return ans
    }
}