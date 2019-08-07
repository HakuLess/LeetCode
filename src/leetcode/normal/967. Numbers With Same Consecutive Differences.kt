package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution967()
//    s.numsSameConsecDiff(3, 7).print()
    s.numsSameConsecDiff(2, 1).print()
//    s.numsSameConsecDiff(1, 0).print()
}

class Solution967 {
    var ans = arrayListOf<Int>()
    fun numsSameConsecDiff(N: Int, K: Int): IntArray {
        if (N == 1) {
            return intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        }
        for (i in 1..9) {
            dfs(N - 1, i, K)
        }
        return ans.distinct().toIntArray()
    }

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
}