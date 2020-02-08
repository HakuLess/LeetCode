package leetcode.contest.cur.b19

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5312()
    s.numOfSubarrays(intArrayOf(2, 2, 2, 2, 5, 5, 5, 8), 3, 4).print()
}

class Solution5312 {
    fun numOfSubarrays(arr: IntArray, k: Int, threshold: Int): Int {
        var ans = 0
        val target = k * threshold
        var cur = 0
        for (i in 0 until k) {
            cur += arr[i]
        }
        for (i in k..arr.lastIndex) {
            if (cur >= target) {
                ans++
            }
            cur += arr[i]
            cur -= arr[i - k]
        }
        return ans + if (cur >= target) 1 else 0
    }
}