package leetcode.contest.cur.leetcode.c254

class Solution5832 {
    fun rearrangeArray(nums: IntArray): IntArray {
        val ans = IntArray(nums.size)
        var left = 0
        var right = nums.size - 1
        var cur = 0
        nums.sort()
        while (cur in nums.indices) {
            if (cur % 2 == 0) {
                ans[cur] = nums[left]
                left++
            } else {
                ans[cur] = nums[right]
                right--
            }
            cur++
        }
        return ans
    }
}