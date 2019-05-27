package leetcode.contest.c138

class Solution1051 {
    fun heightChecker(heights: IntArray): Int {
        val right = heights.sorted()
        var ans = 0
        for (i in 0 until heights.size) {
            if (right[i] != heights[i]) {
                ans++
            }
        }
        return ans
    }
}