package leetcode.contest.cur.leetcode.c248

import leetcode.contest.utils.*

fun main(args: Array<String>) {
    val s = Solution5803()
    s.longestCommonSubpath(5, "[[0,1,2,3,4],[2,3,4],[4,0,1,2,3]]".toGrid()).print()
}

class Solution5803 {
    fun longestCommonSubpath(n: Int, paths: Array<IntArray>): Int {
        var ans = 0
        paths.sortBy { it.size }
        val ori = paths[0]

        fun check(a: Int, b: Int): Boolean {
            val s = ori.toList().subList(a, b)
            if (paths.all {
                        s.joinToString(prefix = ",", separator = ",", postfix = ",") in it.joinToString(prefix = ",", separator = ",", postfix = ",")
                    }) {
                ans = maxOf(ans, s.size)
                return true
            }
            return false
        }

        for (a in ori.indices) {
            var left = a + 1
            var right = ori.size
            while (left + 1 < right) {
                val mid = (left + right).ushr(1)
                when {
                    check(left, mid) -> left = mid
                    else -> right = mid
                }
            }
            check(a, left)
            check(a, right)
        }
        return ans
    }
}