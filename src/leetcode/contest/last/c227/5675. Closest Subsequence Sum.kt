package leetcode.contest.last.c227

import leetcode.contest.utils.print
import leetcode.contest.utils.toAllSubSet
import java.util.*
import kotlin.math.abs

fun main(args: Array<String>) {
    val s = Solution5675()
    s.minAbsDifference(intArrayOf(5, -7, 3, 5), 6).print()
    s.minAbsDifference(intArrayOf(7, -9, 15, -2), -5).print()
}

class Solution5675 {
    fun minAbsDifference(nums: IntArray, goal: Int): Int {
        val n = nums.size
        val m = nums.size / 2
        val a = TreeSet(nums.sliceArray(IntRange(0, m - 1)).toAllSubSet())
        val b = nums.sliceArray(IntRange(m, n - 1)).toAllSubSet()
        var ans = Int.MAX_VALUE
        b.forEach {
            val target = goal - it
            ans = minOf(ans, abs(target - (a.floor(target) ?: 0)))
            ans = minOf(ans, abs(target - (a.ceiling(target) ?: 0)))
            if (ans == 0) return 0
        }
        return ans
    }

//    fun minAbsDifference(nums: IntArray, goal: Int): Int {
//        val n = nums.size
//        val m = nums.size / 2
//        val r = n - m
//        var ans = Int.MAX_VALUE
//        val left = TreeSet<Int>()
//        for (i in 0..(1 shl m)) {
//            var tmp = 0
//            for (j in 0 until m) {
//                if (i and (1 shl j) != 0) tmp += nums[j]
//            }
//            ans = minOf(ans, abs(tmp - goal))
//            left.add(tmp)
//        }
//        for (i in 0..(1 shl r)) {
//            var tmp = 0
//            for (j in 0 until r) {
//                if (i and (1 shl j) != 0) tmp += nums[j + m]
//            }
//            ans = minOf(ans, abs(tmp - goal))
//            val k = goal - tmp
//            ans = minOf(ans, abs(tmp - goal + (left.ceiling(k) ?: 0)))
//            ans = minOf(ans, abs(tmp - goal + (left.floor(k) ?: 0)))
//        }
//        return ans
//    }
}