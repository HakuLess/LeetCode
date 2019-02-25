package leetcode

fun main(args: Array<String>) {
    findMin(intArrayOf(2, 2, 2, 0, 0, 1)).print()
    findMin(intArrayOf(2, 2, 2, 2, 2)).print()
}

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