package leetcode.learn

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution()
    s.stringShift("abc", arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))).print()
    s.stringShift("wpdhhcj", arrayOf(
            intArrayOf(0, 4)
    )).print()
}

class Solution {
    fun stringShift(s: String, shift: Array<IntArray>): String {
        var a = 0
        shift.forEach {
            when (it[0]) {
                1 -> a += it[1]
                0 -> a -= it[1]
            }
        }
        a %= s.length
        return when {
            a == 0 -> {
                s
            }
            a > 0 -> {
                s.substring(s.length - a, s.length) + s.substring(0, s.length - a)
            }
            else -> {
                a = -a
                s.substring(a) + s.substring(0, a)
            }
        }
    }

    fun findMaxLength(nums: IntArray): Int {
        val map = HashMap<Int, Int>()
        map[0] = -1
        var ans = 0
        var count = 0
        for (i in nums.indices) {
            count += if (nums[i] == 1) 1 else -1
            if (map.containsKey(count)) {
                ans = maxOf(ans, i - map[count]!!)
            } else {
                map[count] = i
            }
        }
        return ans
    }
}