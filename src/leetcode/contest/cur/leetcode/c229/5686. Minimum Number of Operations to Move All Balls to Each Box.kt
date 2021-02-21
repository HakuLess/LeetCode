package leetcode.contest.cur.leetcode.c229

import kotlin.math.abs

class Solution5686 {
    fun minOperations(boxes: String): IntArray {
        val n = boxes.length
        val ans = arrayListOf<Int>()
        for (i in 0 until n) {
            var cur = 0
            for (j in 0 until n) {
                if (i != j && boxes[j] == '1')
                    cur += abs(j - i)
            }
            ans.add(cur)
        }
        return ans.toIntArray()
    }
}