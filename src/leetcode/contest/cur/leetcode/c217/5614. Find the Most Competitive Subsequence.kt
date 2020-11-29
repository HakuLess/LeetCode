package leetcode.contest.cur.leetcode.c217

import java.util.*

class Solution5614 {
    fun mostCompetitive(nums: IntArray, k: Int): IntArray {
        val n = nums.size
        val st = Stack<Int>()
        for (i in nums.indices) {
            while (st.isNotEmpty() && st.last() > nums[i] && st.size - 1 + n - i >= k) {
                st.pop()
            }
            if (st.size < k) {
                st.push(nums[i])
            }
        }
        return st.toIntArray()
    }
}