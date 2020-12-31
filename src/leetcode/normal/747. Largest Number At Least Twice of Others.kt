package leetcode.normal

class Solution747 {
    fun dominantIndex(nums: IntArray): Int {
        if (nums.size <= 1) return -1
        val l = nums.sortedDescending()
        return if (l[0] >= l[1] * 2) nums.indexOfFirst { it == l[0] } else -1
    }

//    fun dominantIndex(nums: IntArray): Int {
//        var top1 = Integer.MIN_VALUE
//        var top2 = Integer.MIN_VALUE
//        var ans = -1
//        for (i in nums.indices) {
//            if (nums[i] > top1) {
//                top2 = top1
//                top1 = nums[i]
//                ans = i
//            } else if (nums[i] > top2) {
//                top2 = nums[i]
//            }
//        }
//
//        return if (top1 >= top2 * 2) {
//            ans
//        } else {
//            -1
//        }
//    }
}