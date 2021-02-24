package leetcode.contest.cur.leetcode.c229

import kotlin.math.abs

class Solution5686 {
    fun minOperations(boxes: String): IntArray {
        val n = boxes.length
        val ans = IntArray(n)
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (boxes[j] == '1')
                    ans[i] += abs(j - i)
            }
        }
        return ans
    }
}