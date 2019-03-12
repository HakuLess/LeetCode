package leetcode

fun main(args: Array<String>) {
    val s = Solution312()
    s.maxCoins(intArrayOf(3, 1, 5, 8)).print()
}

class Solution312 {

//    fun maxCoins(nums: IntArray?): Int {
//        if (nums == null || nums.isEmpty()) return 0
//
//        val dp = Array(nums.size) { IntArray(nums.size) }
//        for (i in nums.indices.reversed()) {
//            for (j in i until nums.size) {
//                for (k in i..j) {
//                    val sum = (if (i == 0) 1 else nums[i - 1]) * nums[k] * if (j == nums.size - 1) 1 else nums[j + 1]
//                    val left = if (k == i) 0 else dp[i][k - 1]
//                    val right = if (k == j) 0 else dp[k + 1][j]
//
//                    println("$sum $left $right")
//                    dp[i][j] = Math.max(dp[i][j], left + sum + right)
//                }
//            }
//        }
//        return dp[0][nums.size - 1]
//    }
    fun maxCoins(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        val n = nums.size
        val dp = Array(n) { IntArray(n) }

        for (i in n - 1 downTo 0) {
            for (j in i until n) {
                // fill dp
                for (k in i..j) {
                    val cur = (if (i == 0) 1 else nums[i - 1]) * nums[k] * if (j == n - 1) 1 else nums[j + 1]
                    val left = if (k == i) 0 else dp[i][k - 1]
                    val right = if (k == j) 0 else dp[k + 1][j]

                    println("$cur $left $right")
                    dp[i][j] = maxOf(dp[i][j], left + cur + right)
                }
            }
        }

        return dp[0][n - 1]
    }
}