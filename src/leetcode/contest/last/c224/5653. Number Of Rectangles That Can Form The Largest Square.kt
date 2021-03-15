package leetcode.contest.last.c224

class Solution5653 {
    fun countGoodRectangles(rectangles: Array<IntArray>): Int {
        val arr = rectangles.map { it.min()!! }
        val max = arr.max()!!
        return arr.count { it == max }
    }
}