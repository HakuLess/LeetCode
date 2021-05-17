package leetcode.contest.last.c239

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5747()
    s.splitString("10009998").print()
    s.splitString("9999999999999999998").print()
}

class Solution5747 {
    fun splitString(s: String): Boolean {
        fun dfs(left: Int, cur: Long): Boolean {
            if (left >= s.length) return true
            var ans = false
            for (i in left + 1..s.length) {
                val next = s.substring(left, i).toLongOrNull()
                if (next == cur - 1) {
                    ans = ans or dfs(i, next)
                }
            }
            return ans
        }
        for (i in 1 until s.length) {
            val cur = s.substring(0, i).toLongOrNull() ?: continue
            if (dfs(i, cur)) return true
        }
        return false
    }
}