package leetcode.contest.cur.leetcode.c200

import kotlin.math.abs

class Solution5475 {
    fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
        var ans = 0
        for (i in 0..arr.lastIndex - 2) {
            for (j in i + 1 until arr.lastIndex) {
                for (k in j + 1..arr.lastIndex) {
                    if (abs(arr[i] - arr[j]) <= a && abs(arr[j] - arr[k]) <= b && abs(arr[i] - arr[k]) <= c) {
                        ans++
                    }
                }
            }
        }
        return ans
    }
}