package leetcode

import java.lang.StringBuilder
import java.util.*

class Solution421 {

    fun findMaximumXOR(nums: IntArray): Int {
        var max = 0
        for (i in 0 until nums.size - 1) {
            for (j in i + 1 until nums.size) {
                println("${nums[i]} ${nums[j]} ${nums[i] xor nums[j]}")
                max = maxOf(max, nums[i] xor nums[j])
            }
        }

        return max
    }

}