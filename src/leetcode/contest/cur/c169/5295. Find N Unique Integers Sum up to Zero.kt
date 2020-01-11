package leetcode.contest.cur.c169

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5295()
    s.sumZero(5).print()
    s.sumZero(3).print()
    s.sumZero(1).print()
}

class Solution5295 {
    fun sumZero(n: Int): IntArray {
        val ans = arrayListOf<Int>()
        val last = if (n % 2 == 0) n else n - 1
        for (i in 1..last) {
            if (i % 2 == 0)
                ans.add(-i / 2)
            else
                ans.add((i + 1) / 2)
        }
        if (last == n - 1) {
            ans.add(0)
        }
        return ans.toIntArray()
    }
}