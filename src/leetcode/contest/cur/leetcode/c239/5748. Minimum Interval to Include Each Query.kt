package leetcode.contest.cur.leetcode.c239

import leetcode.contest.utils.SegmentTree
import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid

fun main(args: Array<String>) {
    val s = Solution5748()
    s.minInterval("[[1,4],[2,4],[3,6],[4,4]]".toGrid(), intArrayOf(2, 3, 4, 5)).print()
    s.minInterval("[[2,3],[2,5],[1,8],[20,25]]".toGrid(), intArrayOf(2, 19, 5, 22)).print()
}

class Solution5748 {
    fun minInterval(intervals: Array<IntArray>, queries: IntArray): IntArray {
        val seg = SegmentTree<Int>(start = 0, end = Int.MAX_VALUE / 2, value = Int.MAX_VALUE / 2) { a, b -> minOf(a, b) }
        intervals.sortByDescending { it[1] - it[0] }
        intervals.forEach {
            seg.update(seg, it[0], it[1], it[1] - it[0] + 1)
        }
        val ans = arrayListOf<Int>()
        queries.forEach {
            seg.query(seg, it, it).also {
                if (it >= Int.MAX_VALUE / 2) ans.add(-1)
                else ans.add(it)
            }
        }
        return ans.toIntArray()
    }
}