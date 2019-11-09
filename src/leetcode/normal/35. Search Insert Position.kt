package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution35()
    s.searchInsert(intArrayOf(1, 3, 5, 6), 5).print()
    s.searchInsert(intArrayOf(1, 3, 5, 6), 2).print()
    s.searchInsert(intArrayOf(1, 3, 5, 6), 7).print()
    s.searchInsert(intArrayOf(1, 3, 5, 6), 0).print()
    s.searchInsert(intArrayOf(1, 3, 5, 6), 1).print()
}

class Solution35 {
    fun searchInsert(nums: IntArray, target: Int): Int {
        val ans = nums.binarySearch(target)
        return if (ans >= 0) {
            ans
        } else {
            -ans - 1
        }
    }

//    fun searchInsert(nums: IntArray, target: Int): Int {
//        var start = 0
//        var end = nums.size
//        if (target <= nums[0]) {
//            return 0
//        }
//        if (target > nums[end - 1]) {
//            return end
//        }
//        while (start < end - 1) {
//            when {
//                nums[(start + end) / 2] > target -> end = (start + end) / 2
//                nums[(start + end) / 2] == target -> return (start + end) / 2
//                else -> start = (start + end) / 2
//            }
//        }
//
//        return end
//    }
}