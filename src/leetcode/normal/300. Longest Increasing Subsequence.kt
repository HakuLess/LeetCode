package leetcode.normal

import leetcode.contest.utils.lis
import leetcode.contest.utils.print

class Solution300 {
    fun lengthOfLIS(nums: IntArray): Int {
        return nums.lis()
    }
}