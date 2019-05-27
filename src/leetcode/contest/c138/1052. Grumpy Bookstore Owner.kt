package leetcode.contest.c138

import leetcode.print

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
        for (i in 0 until customers.size) {
            if (grumpy[i] == 0) {
                ans += customers[i]
            }
        }

        var control = 0
        for (i in 0 until customers.size - X + 1) {
            var item = 0
            for (j in i until i + X) {
                if (grumpy[j] == 1) {
                    item += customers[j]
                }
            }
            control = maxOf(control, item)
        }
        return ans + control
    }
}