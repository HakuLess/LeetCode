package leetcode.contest.c137

import leetcode.contest.c136.Solution5056
import leetcode.print
import kotlin.math.abs

fun main(args: Array<String>) {
    val s = Solution1046()
    s.lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1)).print()
}

class Solution1046 {
    fun lastStoneWeight(stones: IntArray): Int {
        var st = stones
        while (st.size > 1) {
            st.sort()
            if (abs(st[st.lastIndex] - st[st.lastIndex - 1]) == 0) {
                val temp = IntArray(st.size - 2)
                for (i in 0 until st.size - 2) {
                    temp[i] = st[i]
                }
                st = temp
            } else {
                val temp = IntArray(st.size - 1)
                for (i in 0 until st.size - 2) {
                    temp[i] = st[i]
                }
                temp[st.size - 2] = abs(st[st.lastIndex] - st[st.lastIndex - 1])
                st = temp
            }
        }
        return if (st.isEmpty()) {
            0
        } else {
            st[0]
        }
    }
}