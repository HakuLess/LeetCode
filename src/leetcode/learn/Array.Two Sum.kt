package leetcode.learn

import leetcode.normal.twoSum
import leetcode.print

fun main(args: Array<String>) {
    val intArray = intArrayOf(2, 7, 11, 15)
    twoSum(intArray, 22).print()
}

//fun twoSum(nums: IntArray, target: Int): IntArray {
//    nums.forEachIndexed { index, value ->
//        val last = nums.lastIndexOf(target - value)
//        if (last > index) {
//            return intArrayOf(index, last)
//        }
//    }
//    return intArrayOf()
//}