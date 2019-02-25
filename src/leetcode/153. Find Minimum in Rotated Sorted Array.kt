package leetcode

fun findMin1(nums: IntArray): Int {
    if (nums.size == 1) {
        return nums[0]
    }

    var left = 0
    var right = nums.lastIndex

    while (left < right) {
        val mid = left + (right - left) / 2

        if (nums[mid] < nums[right]) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return nums[left]
}