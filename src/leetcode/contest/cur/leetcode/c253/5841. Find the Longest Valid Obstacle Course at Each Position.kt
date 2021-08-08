package leetcode.contest.cur.leetcode.c253

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    val s = Solution5841()
//    s.longestObstacleCourseAtEachPosition(intArrayOf(1, 2, 3, 2)).print()
    s.longestObstacleCourseAtEachPosition(intArrayOf(5, 3, 3, 4, 5, 5, 3, 5, 1, 5)).print()
    s.longestObstacleCourseAtEachPosition(intArrayOf(5, 1, 5, 5, 1, 3, 4, 5, 1, 4)).print()
}

class Solution5841 {
    // 最长非递增子序列
    fun longestObstacleCourseAtEachPosition(obstacles: IntArray): IntArray {
        val ts = TreeSet<Int>()
        val map = HashMap<Int, Int>().toSortedMap()
        val ans = ArrayList<Int>()
        obstacles.forEach {
            val lst = ts.floor(it)
            var len = 1
            if (lst != null) {
                len = map[lst]!! + 1
                var ceil = ts.ceiling(it)
                while (ceil != null && map[ceil]!! < len) {
                    ts.remove(ceil)
                    ceil = ts.ceiling(ceil + 1)
                }
            }
            map[it] = len
            ts.add(it)
            ans.add(len)
        }
        return ans.toIntArray()
    }
}