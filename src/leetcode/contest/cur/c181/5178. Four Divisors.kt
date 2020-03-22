package leetcode.contest.cur.c181

import leetcode.contest.utils.print
import kotlin.math.sqrt

fun main(args: Array<String>) {
    val s = Solution5178()
    s.sumFourDivisors(intArrayOf(21, 4, 7)).print()
}

class Solution5178 {
    fun sumFourDivisors(nums: IntArray): Int {
        var ans = 0
        nums.forEach {
            val a = helper(it)
            if (a.count() == 4) {
                ans += a.sum()
            }
        }
        return ans
    }

    private fun helper(num: Int): IntArray {
        val a = arrayListOf<Int>()
        for (i in 1..sqrt(num.toDouble()).toInt()) {
            if (num % i == 0) {
                a.add(i)
                a.add(num / i)
            }
        }
        return a.distinct().toIntArray()
    }
}