package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution416()
//    s.canPartition(intArrayOf(1, 3, 5, 5)).print()
    s.canPartition(intArrayOf(100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100)).print()
}

class Solution416 {

    fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum()
        if (sum % 2 != 0) return false
        val target = sum / 2
        return dp(nums, target)
    }

    private fun dp(nums: IntArray, target: Int): Boolean {
        val dp = arrayListOf<Int>()
        dp.add(0)
        for (i in 0 until nums.size) {
            val size = dp.size
            for (j in 0 until size) {
                if (dp[j] + nums[i] == target) {
                    return true
                } else if (dp[j] + nums[i] < target &&
                        dp[j] + nums[i] !in dp) {
                    dp.add(dp[j] + nums[i])
                }
            }

            dp.forEach {
                print("$it, ")
            }
            println()
            dp.distinct()
        }
        return false
//        val dp = Array(nums.size + 1) { BooleanArray(target + 1) { false } }
//        dp[0][0] = true
//        for (i in 1..nums.size) {
//            for (j in 0..target) {
//                // if we don't pick nums[i]
//                dp[i][j] = dp[i - 1][j]
//
//                // if we pick nums[i]
//                if (j - nums[i - 1] >= 0) {
//                    if (dp[i - 1][j - nums[i - 1]]) {
//                        dp[i][j] = true
//                    }
//                }
//            }
//        }
//
//        dp.print()
//        return dp[nums.size][target]
    }

//    fun canPartition(nums: IntArray): Boolean {
//        return canPartitionKSubsets(nums, 2)
//    }
//
//    private fun search(groups: IntArray, row: Int, nums: IntArray, target: Int): Boolean {
////        var key = "$row, $target: "
////        groups.forEach {
////            key += "$it "
////        }
////        println(key)
//
//        var row = row
//        if (row < 0) return true
//        val v = nums[row--]
//        for (i in groups.indices) {
//            if (groups[i] + v <= target) {
//                groups[i] += v
//                if (search(groups, row, nums, target)) return true
//                groups[i] -= v
//            }
//            if (groups[i] == 0) break
//        }
//        return false
//    }
//
//    private fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
//        var k = k
//        val sum = nums.sum()
//        if (sum % k > 0) return false
//        val target = sum / k
//
//        nums.sort()
//        var row = nums.size - 1
//        if (nums[row] > target) return false
//        while (row >= 0 && nums[row] == target) {
//            row--
//            k--
//        }
//        return search(IntArray(k), row, nums, target)
//    }
}