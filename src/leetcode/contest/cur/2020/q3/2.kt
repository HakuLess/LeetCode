package leetcode.contest.cur.`2020`.q3

import leetcode.contest.utils.print
import leetcode.learn.Solution

fun main(args: Array<String>) {
    val s = Solution2()
    s.breakfastNumber(intArrayOf(10, 20, 5), intArrayOf(5, 5, 2), 15).print()
    s.breakfastNumber(intArrayOf(2, 1, 1), intArrayOf(8, 9, 5, 1), 9).print()
}

class Solution2 {
    fun breakfastNumber(staple: IntArray, drinks: IntArray, x: Int): Int {
        val mod = 1000000007L
        staple.sort()
        var ans = 0L
        for (it in drinks) {
            val index = staple.binarySearch(x - it)
            println("${x - it}, index is $index")
            if (index < 0) {
                ans -= index + 1
            } else {
                ans += index + 1
            }
        }
        return (ans % mod).toInt()
    }
}