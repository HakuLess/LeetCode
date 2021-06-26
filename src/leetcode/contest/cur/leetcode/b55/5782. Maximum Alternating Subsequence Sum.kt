package leetcode.contest.cur.leetcode.b55

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5782()
    s.maxAlternatingSum(intArrayOf(4, 2, 5, 3)).print()
    s.maxAlternatingSum(intArrayOf(5, 6, 7, 8)).print()
    s.maxAlternatingSum(intArrayOf(6, 2, 1, 2, 4, 5)).print()
}

class Solution5782 {
    fun maxAlternatingSum(nums: IntArray): Long {
        var cur = Pair(Long.MIN_VALUE / 2, 0L)
        var even = 0L
        for (num in nums) {
            cur = Pair(maxOf(cur.first, cur.second + num), maxOf(cur.second, cur.first - num))
        }
        return cur.first
    }

//    fun maxAlternatingSum(nums: IntArray): Long {
//        var cur = 0L
//        val st = Stack<Long>()
//        for (i in nums.indices) {
//            val it = nums[i]
//            val t = st.size % 2 != 0
//            if (t) {
//                if (st.isNotEmpty() && it > st.peek()) {
//                    st.pop()
//                    st.push(it.toLong())
//                    continue
//                }
//            } else {
//                if (st.isNotEmpty() && it < st.peek()) {
//                    st.pop()
//                    st.push(it.toLong())
//                    continue
//                }
//            }
//            st.push(it.toLong())
//        }
//        st.joinToString().print()
//        var sum = 0L
//        for (i in st.indices) {
//            if (i % 2 == 0) {
//                sum += st[i]
//            } else {
//                if (i != st.lastIndex)
//                    sum -= st[i]
//            }
//        }
//        return sum
//    }
}