package leetcode.normal

import leetcode.contest.utils.print
import kotlin.math.abs

fun main(args: Array<String>) {
    val s = Solution645()
    s.findErrorNums(intArrayOf(1, 2, 2, 4)).print()
}

class Solution645 {
    fun findErrorNums(nums: IntArray): IntArray {
        val result = intArrayOf(0, 0)
        var sum = 0
        for (value in nums) {
            val num = abs(value)
            if (nums[num - 1] < 0) {
                result[0] = num
            } else {
                nums[num - 1] *= -1
            }
            sum += num
        }
        result[1] = nums.size * (nums.size + 1) / 2 - sum + result[0]
        return result
    }

//    fun findErrorNums(nums: IntArray): IntArray {
//        val n = nums.size
//        val v1 = nums.sum() - n * (n + 1) / 2
//        println(v1)
//        val set = HashSet<Int>()
//        for (i in nums.indices) {
//            set.add(nums[i])
//            if (set.size != i + 1) {
//                return intArrayOf(nums[i], nums[i] - v1)
//            }
//        }
//        return intArrayOf()
//    }
}