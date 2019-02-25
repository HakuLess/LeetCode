package leetcode

fun search(nums: IntArray, target: Int): Boolean {
    var left = 0
    var right = nums.lastIndex

    while (left <= right) {
        val mid = left + (right - left) / 2
        if (nums[mid] == target) {
            return true
        }

        if (nums[mid] == nums[right]) {
            right--
        } else if (nums[mid] > nums[right]) {
            // left is sorted
            if (target >= nums[left] && target < nums[mid]) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        } else {
            // right is sorted
            if (target > nums[mid] && target <= nums[right]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
    }

    return false
}