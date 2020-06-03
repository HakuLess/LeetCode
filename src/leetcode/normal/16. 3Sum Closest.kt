package leetcode.normal

import leetcode.contest.utils.print
import kotlin.math.abs

fun main(args: Array<String>) {
//    val source = arrayListOf(-1,  1, 2,  -4).toIntArray()
    val source = arrayListOf(-3, -2, -5, 3, -4).toIntArray()
    val s = Solution16()
    s.threeSumClosest(source, -1).print()
}

class Solution16 {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var result = nums[0] + nums[1] + nums[2]
        for (i in 0..nums.size - 2) {
            var l = i + 1
            var r = nums.size - 1
            while (l < r) {
                val sum = nums[i] + nums[l] + nums[r]
                if (abs(target - sum) < abs(target - result))
                    result = sum
                if (sum > target) r--
                else l++
            }
        }
        return result
    }
}