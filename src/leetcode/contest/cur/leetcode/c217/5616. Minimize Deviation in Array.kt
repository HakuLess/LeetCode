package leetcode.contest.cur.leetcode.c217

import leetcode.contest.utils.print
import java.util.*


fun main(args: Array<String>) {
    val s = Solution5616()
    s.minimumDeviation(intArrayOf(1, 2, 3, 4)).print()
    s.minimumDeviation(intArrayOf(4, 1, 5, 20, 3)).print()
    s.minimumDeviation(intArrayOf(2, 10, 8)).print()
}

class Solution5616 {
    fun minimumDeviation(nums: IntArray): Int {
        val set = TreeSet<Int>()
        for (num in nums) {
            set.add(if (num % 2 == 0) num else num * 2)
        }
        var res = set.last() - set.first()
        while (res > 0 && set.last() % 2 == 0) {
            val max = set.last()
            set.remove(max)
            set.add(max / 2)
            res = minOf(res, set.last() - set.first())
        }
        return res
    }
//    fun minimumDeviation(nums: IntArray): Int {
//        val a = ArrayList(nums.sorted())
//        var ans = nums.maxOrNull()!! - nums.minOrNull()!!
//        while (a[0] % 2 != 0) {
//            val cur = a[0] * 2
//            a.removeAt(0)
//            val index = a.binarySearch(cur)
//            if (index < 0) {
//                a.add(-index - 1, cur)
//            } else {
//                a.add(index, cur)
//            }
//            ans = minOf(ans, a.last() - a[0])
//        }
//        while (a.last() % 2 == 0) {
//            val cur = a.last() / 2
//            a.removeAt(a.lastIndex)
//            val index = a.binarySearch(cur)
//            if (index < 0) {
//                a.add(-index - 1, cur)
//            } else {
//                a.add(index, cur)
//            }
//            ans = minOf(ans, a.last() - a[0])
//        }
//        return ans
//    }
}