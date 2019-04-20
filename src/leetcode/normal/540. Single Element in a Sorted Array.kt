package leetcode.normal

class Solution540 {
    fun singleNonDuplicate(nums: IntArray): Int {
        if (nums.size == 1) {
            return nums[0]
        }

        val mid = nums.lastIndex / 2
        return if (nums[mid] == nums[mid + 1]) {
            if (mid % 2 == 0) {
                singleNonDuplicate(nums.sliceArray(IntRange(mid + 2, nums.lastIndex)))
            } else {
                singleNonDuplicate(nums.sliceArray(IntRange(0, mid - 1)))
            }
        } else if (nums[mid] == nums[mid - 1]) {
            if (mid % 2 == 0) {
                singleNonDuplicate(nums.sliceArray(IntRange(0, mid - 2)))
            } else {
                singleNonDuplicate(nums.sliceArray(IntRange(mid + 1, nums.lastIndex)))
            }
        } else {
            nums[mid]
        }
    }
}