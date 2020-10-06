package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution967()
//    s.numsSameConsecDiff(3, 7).print()
    s.numsSameConsecDiff(2, 1).print()
//    s.numsSameConsecDiff(1, 0).print()
}

class Solution967 {
    fun numsSameConsecDiff(n: Int, k: Int): IntArray {
        if (n == 1) {
            return intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        }
        val ans = arrayListOf<Int>()
        fun dfs(n: Int, cur: Int, diff: Int) {
            if (n == 0) {
                ans.add(cur)
                return
            }
            if (cur % 10 + diff < 10) {
                dfs(n - 1, cur * 10 + cur % 10 + diff, diff)
            }
            if (cur % 10 - diff >= 0) {
                dfs(n - 1, cur * 10 + cur % 10 - diff, diff)
            }
        }
        for (i in 1..9) {
            dfs(n - 1, i, k)
        }
        return ans.distinct().toIntArray()
    }
}