package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    val array = intArrayOf(2, 2, 3, 4)
    productExceptSelf(array).print()
}

fun productExceptSelf(nums: IntArray): IntArray {
    val leftArray = IntArray(nums.size)
    val rightArray = IntArray(nums.size)
    leftArray[0] = nums.first()
    rightArray[nums.size - 1] = nums.last()
    for (i in 1 until nums.size) {
        leftArray[i] = leftArray[i - 1] * nums[i]
    }

    for (i in nums.size - 2 downTo 0) {
        rightArray[i] = rightArray[i + 1] * nums[i]
    }

    val ans = IntArray(nums.size)
    for (i in 0 until nums.size) {
        when (i) {
            0 -> ans[i] = rightArray[i + 1]
            nums.size - 1 -> ans[i] = leftArray[i - 1]
            else -> ans[i] = leftArray[i - 1] * rightArray[i + 1]
        }
    }
    return ans
}