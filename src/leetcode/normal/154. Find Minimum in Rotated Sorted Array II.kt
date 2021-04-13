package leetcode.normal

class Solution154 {
    fun findMin(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return -1
        }
        var left = 0
        var right = nums.lastIndex
        while (left < right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] > nums[right] -> left = mid + 1
                nums[mid] < nums[right] -> right = mid
                else -> right--
            }
        }
        return nums[right]
    }
}