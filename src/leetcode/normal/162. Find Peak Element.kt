package leetcode.normal

fun findPeakElement(nums: IntArray): Int {
    return search(nums, 0, nums.size - 1)
}

fun search(nums: IntArray, l: Int, r: Int): Int {
    if (l == r) {
        return l
    }
    val mid = l + (r - l) / 2
    return if (nums[mid] > nums[mid + 1]) {
        search(nums, l, mid)
    } else {
        search(nums, mid + 1, r)
    }
}