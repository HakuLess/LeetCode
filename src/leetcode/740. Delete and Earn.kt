package leetcode


class Solution740 {

    fun deleteAndEarn(nums: IntArray): Int {
        val n = 10001
        val sum = IntArray(n)
        nums.forEach {
            sum[it] += it
        }
        val dp = IntArray(n)
        dp[1] = sum[1]
        for (i in 2 until n) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sum[i])
        }
        return dp[n - 1]
    }

//    fun deleteAndEarn(nums: IntArray): Int {
//        val sum = IntArray(10001)
//        nums.forEach {
//            sum[it] += it
//        }
//
//        val dp = IntArray(10001)
//        dp[1] = sum[1]
//        for (i in 2 until 10001) {
//            dp[i] = maxOf(dp[i - 1], dp[i - 2] + sum[i])
//        }
//
//        return dp[10000]
//    }
}