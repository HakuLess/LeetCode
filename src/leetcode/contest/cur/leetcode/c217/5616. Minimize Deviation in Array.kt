package leetcode.contest.cur.leetcode.c217

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs

fun main(args: Array<String>) {
    val s = Solution5616()
    s.minimumDeviation(intArrayOf(1, 2, 3, 4)).print()
    s.minimumDeviation(intArrayOf(4, 1, 5, 20, 3)).print()
    s.minimumDeviation(intArrayOf(2, 10, 8)).print()
}

class Solution5616 {
    fun minimumDeviation(nums: IntArray): Int {
        val a = ArrayList(nums.sorted())
        var ans = nums.max()!! - nums.min()!!
        while (a[0] % 2 != 0) {
            val cur = a[0] * 2
            a.removeAt(0)
            val index = a.binarySearch(cur)
            if (index < 0) {
                a.add(-index - 1, cur)
            } else {
                a.add(index, cur)
            }
            ans = minOf(ans, a.last() - a[0])
        }
        while (a.last() % 2 == 0) {
            val cur = a.last() / 2
            a.removeAt(a.lastIndex)
            val index = a.binarySearch(cur)
            if (index < 0) {
                a.add(-index - 1, cur)
            } else {
                a.add(index, cur)
            }
            ans = minOf(ans, a.last() - a[0])
        }
        return ans
    }
}