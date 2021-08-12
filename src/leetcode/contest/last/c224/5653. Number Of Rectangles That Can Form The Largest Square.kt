package leetcode.contest.last.c224

class Solution5653 {
    fun countGoodRectangles(rectangles: Array<IntArray>): Int {
        val arr = rectangles.map { it.minOrNull()!! }
        val max = arr.maxOrNull()!!
        return arr.count { it == max }
    }
}