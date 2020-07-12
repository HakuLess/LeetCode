package leetcode.contest.cur.leetcode.c197

class Solution5211 {
    fun numIdenticalPairs(nums: IntArray): Int {
        var ans = 0
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[i] == nums[j]) {
                    ans++
                }
            }
        }
        return ans
    }
}