package leetcode.contest.last.c138

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution1052()
    s.maxSatisfied(
            intArrayOf(1, 0, 1, 2, 1, 1, 7, 5),
            intArrayOf(0, 1, 0, 1, 0, 1, 0, 1),
            3
    ).print()
}

class Solution1052 {
    fun maxSatisfied(customers: IntArray, grumpy: IntArray, X: Int): Int {
        var ans = 0
        var add = 0
        val sum = IntArray(grumpy.size + 1)
        for (i in grumpy.indices) {
            if (grumpy[i] == 0) {
                ans += customers[i]
                sum[i + 1] = sum[i]
            } else {
                sum[i + 1] = sum[i] + customers[i]
            }
        }
        for (i in 0 until grumpy.size - X + 1) {
            add = maxOf(add, sum[i + X] - sum[i])
        }
        return ans + add
    }
}