package leetcode

fun pivotIndex(nums: IntArray): Int {
    if (nums.isEmpty() || nums.size == 2) {
        return -1
    }
    if (nums.size == 1) {
        return 1
    }

    var rightSum = nums.sum()
    var leftSum = 0
    for (i in 0 until nums.size) {
        rightSum -= nums[i]
        if (leftSum == rightSum) {
            return i
        }
        leftSum += nums[i]
    }
    return -1
}