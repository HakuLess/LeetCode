package leetcode.contest.cur.c167

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5124()
    s.sequentialDigits(0, 0).forEach {
        it.print()
    }
}

class Solution5124 {
    val ans = arrayListOf<Int>()
    fun sequentialDigits(low: Int, high: Int): List<Int> {
        for (i in 1..9) {
            helper(i)
        }
        return ans.filter {
            it in low..high
        }.sorted()
    }

    private fun helper(cur: Int) {
        ans.add(cur)
        if (cur % 10 != 9) {
            helper(cur * 10 + cur % 10 + 1)
        }
    }
}