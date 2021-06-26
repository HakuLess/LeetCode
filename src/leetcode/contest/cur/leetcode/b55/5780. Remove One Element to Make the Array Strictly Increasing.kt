package leetcode.contest.cur.leetcode.b55

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5780()
    s.canBeIncreasing(intArrayOf(1, 2, 10, 5, 7)).print()
    s.canBeIncreasing(intArrayOf(1, 1, 1)).print()
    s.canBeIncreasing(intArrayOf(105, 924, 32, 968)).print()
}

class Solution5780 {
    fun canBeIncreasing(nums: IntArray): Boolean {
        var remove = false
        for (i in nums.indices) {
            if (i == 0) continue
            if (nums[i] <= nums[i - 1]) {
                if (remove) return false
                remove = true
                if (i >= 2 && nums[i] <= nums[i - 2]) {
                    nums[i] = nums[i - 1]
                }
            }
        }
        return true
    }
}