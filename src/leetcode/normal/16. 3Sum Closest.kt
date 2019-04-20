package leetcode.normal

import kotlin.math.abs

fun main(args: Array<String>) {
//    val source = arrayListOf(-1,  1, 2,  -4).toIntArray()
    val source = arrayListOf(-3, -2, -5, 3, -4).toIntArray()
    println(threeSumClosest(source, -1))
}

fun threeSumClosest(nums: IntArray, target: Int): Int {
    val sorted = nums.sorted()
    var result = nums[0] + nums[1] + nums[2]

    sorted.forEachIndexed { index, it ->
        var left = index + 1
        var right = sorted.size - 1
        val curTarget = target - it
        while (left < right) {
            when {
                sorted[left] + sorted[right] < curTarget -> {
                    if (abs(result - target) > abs(sorted[left] + sorted[right] - curTarget)) {
                        result = sorted[left] + sorted[right] + it
                    }
                    left++
                }
                sorted[left] + sorted[right] == curTarget -> {
                    return target
                }
                else -> {
                    if (abs(result - target) > abs(sorted[left] + sorted[right] - curTarget)) {
                        result = sorted[left] + sorted[right] + it
                    }
                    right--
                }
            }
        }
    }

    return result
}