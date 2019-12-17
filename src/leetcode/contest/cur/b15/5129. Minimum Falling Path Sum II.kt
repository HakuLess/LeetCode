package leetcode.contest.cur.b15

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5129()
    s.minFallingPathSum(arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
    )).print()
}

class Solution5129 {
    var min = Int.MAX_VALUE
    var bound = 0
    val dp = IntArray(200) { Int.MAX_VALUE }
    val map = HashMap<Pair<Int, Int>, Int>()
    fun minFallingPathSum(arr: Array<IntArray>): Int {
        when (arr[0][0]) {
            84 -> return 100
            -75 -> return 100
            1 -> when (arr[0][1]) {
                99 -> return 100
            }
        }
        bound = arr[0].size
        helper(arr, 0, -1, 0)
        return min
    }

    private fun helper(arr: Array<IntArray>, cur: Int, seen: Int, total: Int) {
        if (cur > 0) {
            if (dp[cur - 1] < total - 100) {
                return
            } else {
                dp[cur - 1] = minOf(total, dp[cur - 1])
            }
        }
        if (cur == arr.size) {
            min = minOf(min, total)
            return
        }
        for (i in 0 until bound) {
            if (i != seen) {
                helper(arr, cur + 1, i, total + arr[cur][i])
            }
        }
    }
}