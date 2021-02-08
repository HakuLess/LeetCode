package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution978()
    s.maxTurbulenceSize(intArrayOf(9, 4, 2, 10, 7, 8, 8, 1, 9)).print()
    s.maxTurbulenceSize(intArrayOf(1, 2, 3, 4)).print()
    s.maxTurbulenceSize(intArrayOf(9)).print()
}

class Solution978 {
    fun maxTurbulenceSize(arr: IntArray): Int {
        var ans = 1
        val n = arr.size
        var dp0 = 1
        var dp1 = 1
        for (i in 1 until n) {
            when {
                arr[i - 1] > arr[i] -> {
                    dp0 = dp1 + 1
                    dp1 = 1
                }
                arr[i - 1] < arr[i] -> {
                    dp1 = dp0 + 1
                    dp0 = 1
                }
                else -> {
                    dp0 = 1
                    dp1 = 1
                }
            }
            ans = maxOf(ans, dp0)
            ans = maxOf(ans, dp1)
        }
        return ans
    }
}