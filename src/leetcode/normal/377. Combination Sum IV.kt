package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution377()
    s.combinationSum4(intArrayOf(3, 33, 333), 10000).print()
}

class Solution377 {

//    fun combinationSum4(nums: IntArray, target: Int): Int {
//        if (target == 0) {
//            return 1
//        }
//        var res = 0
//        for (i in nums.indices) {
//            if (target >= nums[i]) {
//                res += combinationSum4(nums, target - nums[i])
//            }
//        }
//        return res
//    }

    fun combinationSum4(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) {
            return 0
        }
        val dp = IntArray(target + 1)
        dp[0] = 1
        for (sum in 0..target) {
            for (num in nums) {
                dp[sum] += if (sum - num >= 0) dp[sum - num] else 0
            }
        }
        return dp[target]
    }
}