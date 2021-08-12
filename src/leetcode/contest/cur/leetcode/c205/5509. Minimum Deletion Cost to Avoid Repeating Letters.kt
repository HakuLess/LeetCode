package leetcode.contest.cur.leetcode.c205

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5509()
    s.minCost("abaac", intArrayOf(1, 2, 3, 4, 5)).print()
    s.minCost("aabaa", intArrayOf(1, 2, 3, 4, 1)).print()
}

class Solution5509 {
    fun minCost(s: String, cost: IntArray): Int {
        var ans = 0
        val l = arrayListOf<Int>()
        var i = 0
        while (i in s.indices) {
            var cur = i
            while (cur + 1 in s.indices && s[cur] == s[cur + 1]) {
                cur++
            }
//            println("index $i, $cur")
            if (cur != i) {
                val s = cost.slice(IntRange(i, cur))
//                println(s.joinToString(", "))
                ans += s.sum() - s.maxOrNull()!!
            }
            i = cur + 1
        }
        return ans
    }
}