package leetcode

import java.util.HashMap


fun main(args: Array<String>) {
    val s = Solution930()
    s.numSubarraysWithSum(intArrayOf(1, 0, 1, 0, 1), 2).print()

//    s.numSubarraysWithSum(intArrayOf(1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0), 3).print()
}

class Solution930 {

    fun numSubarraysWithSum(A: IntArray, S: Int): Int {
        val dp = IntArray(A.size + 1)
        for (i in A.indices) {
            dp[i + 1] = dp[i] + A[i]
        }

        val count = HashMap<Int, Int>()
        var ans = 0
        for (c in dp) {
            ans += count.getOrDefault(c, 0)
            count[c + S] = count.getOrDefault(c + S, 0) + 1
        }
        return ans
    }
}