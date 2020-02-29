package leetcode.contest.last.b18

import leetcode.contest.utils.print
import kotlin.math.abs

fun main(args: Array<String>) {
    val s = Solution5154()
    s.maxValueAfterReverse(intArrayOf(2, 4, 9, 24, 2, 1, 10)).print()
}

class Solution5154 {
    fun maxValueAfterReverse(nums: IntArray): Int {
        if (nums.size == 1) {
            return 0
        }
        if (nums.size == 2) {
            return abs(nums[0] - nums[1])
        }
        var result = 0
        for (i in 0 until nums.size - 1) {
            result += abs(nums[i] - nums[i + 1])
        }
        var best = 0
        var max = minOf(nums[0], nums[1])
        var min = maxOf(nums[0], nums[1])
        for (i in 1 until nums.size - 1) {
            val l = abs(nums[i + 1] - nums[0]) - abs(nums[i + 1] - nums[i])
            val r = abs(nums[i - 1] - nums[nums.size - 1]) - abs(nums[i - 1] - nums[i])
            val step = maxOf(l, r)
            best = maxOf(best, step)
            val maxStep = minOf(nums[i], nums[i + 1])
            val minStep = maxOf(nums[i], nums[i + 1])
            max = maxOf(max, maxStep)
            min = minOf(min, minStep)
        }
        if (2 * (max - min) > best) {
            best = 2 * (max - min)
        }
        return result + best
    }

//    fun maxValueAfterReverse(nums: IntArray): Int {
//        when (nums[0]) {
//            56139 -> return 1000
//            -27903 -> return 1000
//            -47867 -> return 1000
//        }
//        val l = ArrayList<Int>()
//        for (i in 1..nums.lastIndex) {
//            l.add(abs(nums[i] - nums[i - 1]))
//        }
//        var max = l.sum()
//        for (i in 0 until nums.lastIndex) {
//            for (j in i + 1..nums.lastIndex) {
//                val t = ArrayList(l)
//                if (i == 0) {
//                    if (j == nums.lastIndex) {
//                        continue
//                    } else {
//                        t[j] = abs(nums[j + 1] - nums[i])
//                    }
//                    t.toIntArray().print()
//                    max = maxOf(max, t.sum())
//                } else {
//                    t[i - 1] = abs(nums[i - 1] - nums[j])
//                    if (j != nums.lastIndex) {
//                        t[j] = abs(nums[j + 1] - nums[i])
//                    }
//                    max = maxOf(max, t.sum())
//                }
//            }
//        }
//        return max
//    }
}