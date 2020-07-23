package leetcode.normal

import leetcode.contest.utils.Interval

/**
 * Definition for an interval.
 * class Interval(
 *     var start: Int = 0,
 *     var end: Int = 0
 * )
 */
class Solution986 {
    fun intervalIntersection(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray> {
        val ans = arrayListOf<IntArray>()
        for (i in A.indices) {
            for (j in B.indices) {
                if (A[i][0] > B[j][1]) {
                    continue
                }
                if (A[i][1] < B[j][0]) {
                    break
                }
                ans.add(intArrayOf(maxOf(A[i][0], B[j][0]), minOf(A[i][1], B[j][1])))
            }
        }
        return ans.toTypedArray()
    }
}