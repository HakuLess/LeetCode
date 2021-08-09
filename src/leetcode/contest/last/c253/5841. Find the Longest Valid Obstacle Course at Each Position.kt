package leetcode.contest.last.c253

import leetcode.contest.utils.biFirstIndexOf
import leetcode.contest.utils.print
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    val s = Solution5841()
//    s.longestObstacleCourseAtEachPosition(intArrayOf(1, 2, 3, 2)).print()
    s.longestObstacleCourseAtEachPosition(intArrayOf(5, 3, 3, 4, 5, 5, 3, 5, 1, 5)).print()
    s.longestObstacleCourseAtEachPosition(intArrayOf(5, 1, 5, 5, 1, 3, 4, 5, 1, 4)).print()
}

class Solution5841 {
    // 最长非递增子序列
    fun longestObstacleCourseAtEachPosition(obstacles: IntArray): IntArray {
        val ans = ArrayList<Int>()
        val cur = ArrayList<Int>()
        obstacles.forEach {
            // 若要严格递增，这里>改为>=
            val index = cur.biFirstIndexOf { c -> c > it }
            ans.add(
                if (index == -1) {
                    cur.add(it)
                    cur.size
                } else {
                    cur[index] = it
                    index + 1
                }
            )
        }
        return ans.toIntArray()
    }
}