package leetcode

fun findMin(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return -1
    }

    var left = 0
    var right = nums.size - 1
    while (left != right) {
        val mid = left + (right - left) / 2
        if (nums[mid] > nums[left]) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return nums[right]
}