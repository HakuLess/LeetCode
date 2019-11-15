package leetcode.normal

import leetcode.contest.utils.print
import kotlin.math.abs

fun main(args: Array<String>) {
    val s = Solution41()
    s.firstMissingPositive(intArrayOf(1, 2, 0)).print()
    s.firstMissingPositive(intArrayOf(3, 4, -1, 1)).print()
    s.firstMissingPositive(intArrayOf(7, 8, 9, 11, 12)).print()
    s.firstMissingPositive(intArrayOf(1, 2, 3)).print()
}

class Solution41 {
    fun firstMissingPositive(nums: IntArray): Int {
        for (i in 0..nums.lastIndex) {
            var j = nums[i]
            while (j in 1..nums.size && nums[j - 1] != j) {
                val temp = nums[j - 1]
                nums[j - 1] = j
                j = temp
            }
        }

        for (i in nums.indices) {
            if (nums[i] != i + 1) {
                return i + 1
            }
        }
        return nums.size + 1
    }

//    fun firstMissingPositive(nums: IntArray): Int {
//        val n = nums.size
//        if (!nums.contains(1))
//            return 1
//        if (n == 1)
//            return 2
//
//        for (i in 0 until n)
//            if (nums[i] <= 0 || nums[i] > n)
//                nums[i] = 1
//
//        for (i in 0 until n) {
//            val a = abs(nums[i])
//            if (a == n)
//                nums[0] = -abs(nums[0])
//            else
//                nums[a] = -abs(nums[a])
//        }
//
//        for (i in 1 until n) {
//            if (nums[i] > 0)
//                return i
//        }
//
//        return if (nums[0] > 0) n else n + 1
//    }
}