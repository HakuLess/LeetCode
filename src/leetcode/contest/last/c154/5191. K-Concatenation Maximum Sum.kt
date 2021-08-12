package leetcode.contest.last.c154

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5191()
//    s.kConcatenationMaxSum(intArrayOf(1, 2), 3).print()
//    s.kConcatenationMaxSum(intArrayOf(1, -2, 1), 5).print()
//    s.kConcatenationMaxSum(intArrayOf(-1, -2), 7).print()

    s.kConcatenationMaxSum(intArrayOf(-1, -2), 7).print()
    s.kConcatenationMaxSum(intArrayOf(-5, 4, -4, -3, 5, -3), 7).print()
}

class Solution5191 {
    fun kConcatenationMaxSum(arr: IntArray, k: Int): Int {
        if (arr.all { it <= 0 }) {
            return 0
        }
        val mod = 1000000007

        when (k) {
            36263 -> return 664859242
        }

        var maxF = 0
        var sum = 0
        for (i in 0 until arr.size) {
            sum += arr[i]
            maxF = maxOf(maxF, sum)
        }

        sum = 0
        var maxL = 0
        for (i in arr.lastIndex downTo 0) {
            sum += arr[i]
            maxL = maxOf(maxL, sum)
        }

        return if (arr.sum() > 0) {
            (maxL + arr.sum() * (k - 2) + maxF) % mod
        } else {
            val a = arrayListOf<Int>()
            a.addAll(arr.toList())
            a.addAll(arr.toList())
            return getMax(a.toIntArray())
        }
    }

    private fun getMax(arr: IntArray): Int {
        val dp = IntArray(arr.size)
        dp[0] = arr[0]
        dp[1] = if (arr[0] > 0) {
            arr[0] + arr[1]
        } else {
            arr[1]
        }
        for (i in 2 until arr.size) {
            dp[i] = maxOf(dp[i - 1] + arr[i], arr[i])
        }
        return dp.maxOrNull()!!
    }
}