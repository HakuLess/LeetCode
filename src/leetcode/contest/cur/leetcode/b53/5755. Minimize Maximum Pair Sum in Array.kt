package leetcode.contest.cur.leetcode.b53

class Solution5755 {
    fun minPairSum(nums: IntArray): Int {
        nums.sort()
        var ans = 0
        for (i in nums.indices) {
            ans = maxOf(ans, nums[i] + nums[nums.lastIndex - i])
        }
        return ans
    }
}