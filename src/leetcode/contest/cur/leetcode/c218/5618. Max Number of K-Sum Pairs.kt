package leetcode.contest.cur.leetcode.c218

class Solution5618 {
    fun maxOperations(nums: IntArray, k: Int): Int {
        nums.sort()
        var left = 0
        var right = nums.lastIndex
        var ans = 0
        while (left < right) {
            val v = nums[left] + nums[right]
            when {
                v == k -> {
                    ans++
                    left++
                    right--
                }
                v < k -> {
                    left++
                }
                else -> {
                    right--
                }
            }
        }
        return ans
    }
}