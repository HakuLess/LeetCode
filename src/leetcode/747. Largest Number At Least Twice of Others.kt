package leetcode

fun dominantIndex(nums: IntArray): Int {

    var top1 = Integer.MIN_VALUE
    var top2 = Integer.MIN_VALUE
    var ans = -1
    for (i in 0 until nums.size) {
        if (nums[i] > top1) {
            top2 = top1
            top1 = nums[i]
            ans = i
        } else if (nums[i] > top2) {
            top2 = nums[i]
        }
    }

    return if (top1 >= top2 * 2) {
        ans
    } else {
        -1
    }
}