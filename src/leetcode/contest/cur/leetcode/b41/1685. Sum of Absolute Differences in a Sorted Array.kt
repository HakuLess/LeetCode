package leetcode.contest.cur.leetcode.b41

class Solution1685 {
    fun getSumAbsoluteDifferences(nums: IntArray): IntArray {
        val n = nums.size
        var cur = nums.sum()
        cur -= n * nums[0]
        val ans = arrayListOf<Int>()
        for (i in nums.indices) {
            if (i > 0) {
                cur += (2 * i - n) * (nums[i] - nums[i - 1])
            }
            ans.add(cur)
        }
        return ans.toIntArray()
    }
}