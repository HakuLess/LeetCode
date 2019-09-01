package leetcode.contest.cur.c152

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5174()
    s.dietPlanPerformance(intArrayOf(1, 2, 3, 4, 5), 1, 3, 3).print()
    s.dietPlanPerformance(intArrayOf(3, 2), 2, 0, 1).print()
    s.dietPlanPerformance(intArrayOf(6, 5, 0, 0), 2, 1, 5).print()
    s.dietPlanPerformance(intArrayOf(6, 13, 8, 7, 10, 1, 12, 11), 6, 5, 37).print()
}

class Solution5174 {
    fun dietPlanPerformance(calories: IntArray, k: Int, lower: Int, upper: Int): Int {
        var count = 0
        var total = 0
        var res = 0
        for (i in 0 until calories.size) {
            count++
            total += calories[i]
            if (count == k) {
                count--
                if (total < lower) {
                    res--
                }
                if (total > upper) {
                    res++
                }
                total -= calories[i - k + 1]
            }
        }
        return res
    }
}