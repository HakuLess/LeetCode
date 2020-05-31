package leetcode.contest.cur.c191

class Solution5424 {
    fun maxProduct(nums: IntArray): Int {
        var ans = Int.MIN_VALUE
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                ans = maxOf(ans, (nums[i] - 1) * (nums[j] - 1))
            }
        }
        return ans
    }
}