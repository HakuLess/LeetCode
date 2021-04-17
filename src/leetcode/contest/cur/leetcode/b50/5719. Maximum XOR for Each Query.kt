package leetcode.contest.cur.leetcode.b50

import leetcode.contest.utils.print
import kotlin.math.pow

fun main(args: Array<String>) {
    val s = Solution5719()
    s.getMaximumXor(intArrayOf(0, 1, 1, 3), 2).print()
}

class Solution5719 {
    fun getMaximumXor(nums: IntArray, maximumBit: Int): IntArray {
        val ans = ArrayList<Int>()
        val arr = nums.map { it.toString(2).takeLast(maximumBit).toInt(2) }
        var cur = arr[0]
        ans.add((2.0.pow(maximumBit).toInt() - 1) xor cur)
        for (i in 1 until arr.size) {
            cur = cur xor arr[i]
            ans.add((2.0.pow(maximumBit).toInt() - 1) xor cur)
        }
        return ans.reversed().toIntArray()
    }
}