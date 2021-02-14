package leetcode.normal

import java.util.*


class Solution448 {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val n: Int = nums.size
        for (num in nums) {
            val x = (num - 1) % n
            nums[x] += n
        }
        val ret = ArrayList<Int>()
        for (i in 0 until n) {
            if (nums[i] <= n) {
                ret.add(i + 1)
            }
        }
        return ret
    }
}