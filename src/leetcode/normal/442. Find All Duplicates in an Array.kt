package leetcode.normal

import java.util.ArrayList
import kotlin.math.abs

class Solution442 {
    fun findDuplicates(nums: IntArray): List<Int> {
        val result = ArrayList<Int>()
        for (i in nums.indices) {
            if (nums[abs(nums[i]) - 1] >= 0) {
                nums[abs(nums[i]) - 1] *= -1
            } else {
                result.add(abs(nums[i]))
            }
        }
        return result
    }
}