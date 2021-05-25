package leetcode.contest.last.c138

class Solution1051 {
    fun heightChecker(heights: IntArray): Int {
        val right = heights.sorted()
        var ans = 0
        for (i in heights.indices) {
            if (right[i] != heights[i]) {
                ans++
            }
        }
        return ans
    }
}