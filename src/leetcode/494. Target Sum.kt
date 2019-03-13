package leetcode


fun main(args: Array<String>) {
    val s = Solution494()
    s.findTargetSumWays(intArrayOf(1, 1, 1, 1, 1, 1), 3).print()
}

class Solution494 {

    fun findTargetSumWays(nums: IntArray, S: Int): Int {
        val sum = nums.sum()

        if (sum < S || sum % 2 == S % 2) {
            return 0
        }
        val target = (sum + S) / 2
        val dp = IntArray(target + 1)
        dp[0] = 1
        for (n in nums) {
            for (i in target downTo n) {
                dp[i] += dp[i - n]
            }
//            dp.print()
        }
        dp.print()
        return dp[target]
    }

//    fun findTargetSumWays(nums: IntArray, S: Int): Int {
//        val sum = nums.sum()
//        val target = (sum + S) / 2
//
//        // find target
//        val dp = Array(nums.size + 1) { IntArray(target + 1) }
//        dp[0][0] = 1
//        for (i in 1..nums.size) {
//            for (j in 0..target) {
//                if (j == 0) {
//                    dp[i][j] = 1
//                }
//                dp[i][j] = dp[i - 1][j]
////                dp[i][j] = dp[i - 1][j]
//                if (j - nums[i - 1] == 0) {
//                    dp[i][j]++
//                } else if (j - nums[i - 1] >= 0) {
//                    dp[i][j] = dp[i - 1][j - nums[i - 1]]
//                }
//            }
//        }
//        dp.print()
//        return dp[nums.size - 1][target]
//    }


}
//
//fun findTargetSumWays(nums: IntArray, S: Int): Int {
//    var ans = 0
//    ans += dfs(0, 0, nums, S)
//    return ans
//}
//
//fun dfs(cur: Int, pos: Int, nums: IntArray, target: Int): Int {
//    if (pos == nums.size) {
//        return if (cur == target) {
//            1
//        } else {
//            0
//        }
//    }
//
//    return dfs(cur + nums[pos], pos + 1, nums, target) + dfs(cur - nums[pos], pos + 1, nums, target)
//}