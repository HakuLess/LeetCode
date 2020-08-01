package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution523()
//    s.checkSubarraySum(intArrayOf(23, 2, 4, 6, 7), 6).print()
//    s.checkSubarraySum(intArrayOf(23, 2, 6, 4, 7), 6).print()
    s.checkSubarraySum(intArrayOf(0, 0), 0).print()
}

class Solution523 {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        var sum = 0
        val map = hashMapOf<Int, Int>()
        map[0] = -1
        for (i in nums.indices) {
            sum += nums[i]
            if (k != 0) {
                sum %= k
            }
            if (map.containsKey(sum)) {
                if (i - map[sum]!! > 1) {
                    return true
                }
            } else {
                map[sum] = i
            }
        }
        return false
    }
}