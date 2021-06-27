package leetcode.contest.cur.leetcode.b55

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5780()
    s.canBeIncreasing(intArrayOf(2, 3, 1, 2)).print()
//    s.canBeIncreasing(intArrayOf(1, 2, 10, 5, 7)).print()
//    s.canBeIncreasing(intArrayOf(1, 1, 1)).print()
//    s.canBeIncreasing(intArrayOf(105, 924, 32, 968)).print()
}

class Solution5780 {
    // 删除某一元素，数组严格递增
    fun canBeIncreasing(nums: IntArray): Boolean {
        for (i in nums.indices) {
            var lst = -1
            var res = true
            for (j in nums.indices) {
                if (i == j) continue
                if (nums[j] <= lst) {
                    res = false
                    break
                }
                lst = nums[j]
            }
            if (res) {
                return res
            }
        }
        return false
    }

//    fun canBeIncreasing(nums: IntArray): Boolean {
//        var remove = false
//        for (i in nums.indices) {
//            if (i == 0) continue
//            if (nums[i] <= nums[i - 1]) {
//                if (remove) return false
//                remove = true
//                if (i >= 2 && nums[i] <= nums[i - 2]) {
//                    nums[i] = nums[i - 1]
//                }
//            }
//        }
//        return true
//    }
}