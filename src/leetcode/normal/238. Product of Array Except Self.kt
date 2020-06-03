package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution238()
    s.productExceptSelf(intArrayOf(2, 2, 3, 4)).print()
}

class Solution238 {
    //    fun productExceptSelf(nums: IntArray): IntArray {
//        val product = nums.reduce { acc, i ->  acc * i}
//        return nums.map {
//            product / it
//        }.toIntArray()
//    }

    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        var left = 1
        for (i in nums.indices) {
            result[i] = left
            left *= nums[i]
        }
        var right = 1
        for (i in nums.size - 1 downTo 0) {
            result[i] *= right
            right *= nums[i]
        }
        return result
    }
}