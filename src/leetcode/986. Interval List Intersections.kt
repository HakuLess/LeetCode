package leetcode

import kotlin.math.max

/**
 * Definition for an interval.
 * class Interval(
 *     var start: Int = 0,
 *     var end: Int = 0
 * )
 */
class Solution986 {

    fun intervalIntersection(A: Array<Interval>, B: Array<Interval>): Array<Interval> {
        val ans = arrayListOf<Interval>()
        for (i in 0 until A.size) {
            for (j in 0 until B.size) {
                if (A[i].start > B[j].end) {
                    continue
                }
                if (A[i].end < B[j].start) {
                    break
                }

                ans.add(Interval(maxOf(A[i].start, B[j].start), minOf(A[i].end, B[j].end)))
            }
        }
        return ans.toTypedArray()
    }
}