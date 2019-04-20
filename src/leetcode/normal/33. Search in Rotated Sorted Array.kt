package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    search(intArrayOf(3), 3).print()
}

fun search1(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.lastIndex

    while (left <= right) {
        val mid = left + (right - left) / 2
        if (nums[mid] == target) {
            return mid
        }

        if (nums[mid] > nums[right]) {
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

    return -1
}