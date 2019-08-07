package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution650()
//    s.minSteps(7).print()
    s.minSteps(1).print()
}

class Solution650 {

    fun minSteps(n: Int): Int {
        if (n == 0 || n == 1) {
            return 0
        }
        return getMin(1, 0, n)
    }

    private fun getMin(cur: Int, step: Int, n: Int): Int {
        println("$cur, $step, $n")
        if (step == 0) {
            return 1 + getMin(cur, cur, n)
        }
        return if (cur + step == n) {
            1
        } else if (cur + step > n) {
            Integer.MAX_VALUE / 2
        } else {
            if (cur == step) {
                1 + getMin(cur + step, step, n)
            } else {
                1 + minOf(getMin(cur + step, step, n),
                        getMin(cur, cur, n))
            }
        }
    }
}