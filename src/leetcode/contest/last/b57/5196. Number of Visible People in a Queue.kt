package leetcode.contest.last.b57

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5196()
    s.canSeePersonsCount(intArrayOf(10, 6, 8, 5, 11, 9)).print()
}

class Solution5196 {
    fun canSeePersonsCount(heights: IntArray): IntArray {
        val ans = IntArray(heights.size)
        val st = Stack<Pair<Int, Int>>()
        for (i in heights.indices.reversed()) {
            val h = heights[i]
            var cur = 0
            while (st.isNotEmpty() && h > st.peek().second) {
                st.pop()
                cur++
            }
            if (st.isNotEmpty()) {
                cur++
            }
            st.push(Pair(i, h))
            ans[i] = cur
        }
        return ans
    }
}