package leetcode.normal


class NumArray(nums: IntArray) {

    val nums = nums
    private var sum: IntArray = IntArray(nums.size + 1)

    init {
        for (i in 0 until nums.size) {
            sum[i + 1] = sum[i] + nums[i]
        }
    }

    fun sumRange(i: Int, j: Int): Int {
        return sum[j + 1] - sum[i]
    }
}