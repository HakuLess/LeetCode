package leetcode.normal

import leetcode.contest.utils.print
import java.util.HashMap


fun main(args: Array<String>) {
    val s = Solution930()
    s.numSubarraysWithSum(intArrayOf(1, 0, 1, 0, 1), 2).print()

//    s.numSubarraysWithSum(intArrayOf(1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0), 3).print()
}

class Solution930 {
    fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
        val dp = IntArray(nums.size + 1)
        for (i in nums.indices) {
            dp[i + 1] = dp[i] + nums[i]
        }

        val count = HashMap<Int, Int>()
        var ans = 0
        for (c in dp) {
            ans += count.getOrDefault(c, 0)
            count[c + goal] = count.getOrDefault(c + goal, 0) + 1
        }
        return ans
    }
}