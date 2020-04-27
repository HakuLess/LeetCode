package leetcode.contest.cur.mst

class Solution56 {
    fun singleNumbers(nums: IntArray): IntArray? {
        var xorNumber = nums[0]
        for (k in 1 until nums.size) {
            xorNumber = xorNumber xor nums[k]
        }
        val onePosition = xorNumber and -xorNumber
        var ans1 = 0
        var ans2 = 0
        for (i in nums.indices) {
            if (nums[i] and onePosition == onePosition) {
                ans1 = ans1 xor nums[i]
            } else {
                ans2 = ans2 xor nums[i]
            }
        }
        return intArrayOf(ans1, ans2)
    }
}