package leetcode.contest.last.c190

import leetcode.contest.utils.print


fun main(args: Array<String>) {
    val s = Solution5419()

//    s.maxDotProduct(intArrayOf(2, 1, -2, 5), intArrayOf(3, 0, -6)).print()
//    s.maxDotProduct(intArrayOf(5, -4, -3), intArrayOf(-4, -3, 0, -4, 2)).print()
//    s.maxDotProduct(intArrayOf(3, -1, 0), intArrayOf(4, 5, 3)).print()
//    s.maxDotProduct(intArrayOf(2, 1, -2, 5), intArrayOf(3, 0, -6)).print()
//    s.maxDotProduct(intArrayOf(3, -2), intArrayOf(2, -6, 7)).print()
//    s.maxDotProduct(intArrayOf(-1, -1), intArrayOf(1, 1)).print()
    s.maxDotProduct(intArrayOf(13, -7, 12, -15, -7, 8, 3, -7, -5, 13, -15, -8, 5, 7, -1, 3, -11, -12, 2, -12), intArrayOf(-1, 13, -4, -2, -13, 2, -4, 6, -9, 13, -8, -3, -9)).print()
}

class Solution5419 {

    fun maxDotProduct(nums1: IntArray, nums2: IntArray): Int {
        val m = nums1.size
        val n = nums2.size
        val dp = Array(n + 1) { IntArray(m + 1) { Int.MIN_VALUE / 2 } }
        for (i in 1..n)
            for (j in 1..m) {
                dp[i][j] = nums1[j - 1] * nums2[i - 1]
                println("$i, $j :${dp[i][j]}")
                dp[i][j] = maxOf(dp[i][j], dp[i - 1][j])
                dp[i][j] = maxOf(dp[i][j], dp[i][j - 1])
//                println("${A[j - 1] * B[i - 1]}, ${dp[i][j - 1]} ${dp[i - 1][j]}")
//                println("a ${dp[i][j]}")
                dp[i][j] = maxOf(dp[i][j], dp[i - 1][j - 1] + nums1[j - 1] * nums2[i - 1])
//                println("b ${dp[i][j]}")
            }
        dp.print()
        return dp[n][m]
    }

//    private val seen = HashMap<Pair<Int, Int>, Int>()
//
//    fun maxDotProduct(nums1: IntArray, nums2: IntArray): Int {
//        if (nums1.all { it > 0 } && nums2.all { it < 0 }) {
//            return nums1.min()!! * nums2.max()!!
//        }
//        if (nums1.all { it < 0 } && nums2.all { it > 0 }) {
//            return nums2.min()!! * nums1.max()!!
//        }
//        return helper(nums1, nums2, 0, 0)
//    }
//
//    private fun helper(nums1: IntArray, nums2: IntArray, a: Int, b: Int): Int {
//        if (a !in nums1.indices || b !in nums2.indices) {
//            return 0
//        }
//        if (Pair(a, b) in seen) {
//            return seen[Pair(a, b)]!!
//        }
//        var ans = Int.MIN_VALUE / 2
//        ans = maxOf(ans, nums1[a] * nums2[b] + helper(nums1, nums2, a + 1, b + 1))
//        ans = maxOf(ans, helper(nums1, nums2, a + 1, b))
//        ans = maxOf(ans, helper(nums1, nums2, a, b + 1))
//        return ans
//    }
}