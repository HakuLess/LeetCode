package leetcode.contest.last.c153

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5182()
    s.maximumSum(intArrayOf(1, -2, 0, 3)).print()
    s.maximumSum(intArrayOf(1, -2, -2, 3)).print()
    s.maximumSum(intArrayOf(-1, -1, -1, -1)).print()
}

class Solution5182 {
    fun maximumSum(arr: IntArray): Int {
        if (arr.isEmpty()) {
            return 0
        } else if (arr.size == 1) {
            return arr[0]
        }

        if (arr.all { it <= 0 }) {
            return arr.maxOrNull()!!
        }

        return getMax(arr)
    }

    private fun getMax(arr: IntArray): Int {
        val dp = IntArray(arr.size)
        dp[0] = arr[0]
        dp[1] = if (arr[0] > 0) {
            arr[0] + arr[1]
        } else {
            arr[1]
        }
        val dp2 = IntArray(arr.size)
        dp2[0] = maxOf(dp[0], 0)
        dp2[1] = if (arr[1] < 0) {
            dp2[0]
        } else {
            dp[1]
        }

        for (i in 2 until arr.size) {
            dp[i] = maxOf(dp[i - 1] + arr[i], arr[i])
            dp2[i] = maxOf(dp2[i - 1] + arr[i], arr[i])
            if (arr[i] < 0) {
                dp2[i] = maxOf(dp[i - 1], dp2[i])
            } else {
                dp2[i] = maxOf(dp[i], dp2[i])
            }
        }
        dp.print()
        dp2.print()
        return maxOf(dp.maxOrNull()!!, dp2.maxOrNull()!!)
    }
}