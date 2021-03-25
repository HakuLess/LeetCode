package leetcode.normal

import leetcode.contest.utils.print
import java.util.*


fun main(args: Array<String>) {
    val s = Solution456()
    s.find132pattern(intArrayOf(1, 0, 1, -4, -3)).print()
}

class Solution456 {
    fun find132pattern(nums: IntArray): Boolean {
        if (nums.size < 3) return false
        var last = Int.MIN_VALUE
        val st = Stack<Int>()
        for (i in nums.lastIndex downTo 0) {
            if (nums[i] < last) return true
            while (!st.isEmpty() && st.peek() < nums[i]) {
                last = st.pop()
            }
            st.push(nums[i])
        }
        return false
    }
}