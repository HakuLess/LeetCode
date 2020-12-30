package leetcode.normal

class Solution330 {
    fun minPatches(nums: IntArray, n: Int): Int {
        var ans = 0
        var x = 1L
        var index = 0
        while (x <= n) {
            if (index in nums.indices && nums[index] <= x) {
                x += nums[index]
                index++
            } else {
                x *= 2
                ans++
            }
        }
        return ans
    }
}