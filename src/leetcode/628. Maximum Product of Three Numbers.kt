package leetcode

class Solution628 {

    fun maximumProduct(nums: IntArray): Int {
        nums.sort()
        return maxOf(nums[0] * nums[1] * nums[nums.lastIndex],
                nums[nums.lastIndex] * nums[nums.lastIndex - 1] * nums[nums.lastIndex - 2])
    }
}