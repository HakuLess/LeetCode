package leetcode

fun findPeakElement(nums: IntArray): Int {
    for (i in 0 until nums.size - 1) {
        if (nums[i] > nums[i + 1]) {
            return i
        }
    }
    return nums.lastIndex
}