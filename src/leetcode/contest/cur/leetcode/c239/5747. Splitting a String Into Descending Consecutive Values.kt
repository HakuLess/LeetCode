package leetcode.contest.cur.leetcode.c239

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5747()
    s.splitString("10009998").print()
    s.splitString("9999999999999999998").print()
}

class Solution5747 {
    fun splitString(s: String): Boolean {
        fun dfs(left: Int, cur: Long): Boolean {
//            println("left is $left cur is $cur")
            if (left >= s.length) return true
            var ans = false
            for (i in left + 1..s.length) {
                try {
                    val next = s.substring(left, i).toLong()
//                println("cur is $cur next is $next")
                    if (next == cur - 1) {
                        ans = ans or dfs(i, next)
                    }
                } catch (ex: Exception) {

                }
            }
            return ans
        }
        for (i in 1 until s.length) {
            try {
                val cur = s.substring(0, i).toLong()
                if (dfs(i, cur)) return true
            } catch (ex: Exception) {

            }
        }
        return false
    }
}