package leetcode.normal

class Solution215 {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        nums.sortDescending()
        return nums[k]
    }
}