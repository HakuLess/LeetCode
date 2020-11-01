package leetcode.contest.cur.leetcode.c213

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5556()
    s.furthestBuilding(intArrayOf(4, 2, 7, 6, 9, 14, 12), 5, 1).print()
}

class Solution5556 {
    fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
        val h = arrayListOf<Int>()
        for (i in 1 until heights.size) {
            var v = 0
            if (heights[i] > heights[i - 1]) {
                v = heights[i] - heights[i - 1]
            }
            h.add(v)
        }
        fun check(end: Int): Boolean {
            val d = h.subList(0, end).sorted().reversed().drop(ladders)
            return (bricks >= d.sum())
        }
        var left = 0
        var right = heights.size - 1
        while (left + 1 < right) {
            val mid = (right + left) / 2
            if (check(mid)) {
                left = mid
            } else {
                right = mid
            }
        }
        if (check(right)) {
            return right
        }
        if (check(left)) {
            return left
        }
        return 0
    }
}