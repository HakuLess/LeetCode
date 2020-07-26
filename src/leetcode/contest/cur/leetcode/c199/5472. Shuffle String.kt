package leetcode.contest.cur.leetcode.c199

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5472()
    s.restoreString("aiohn", intArrayOf(3, 1, 4, 2, 0)).print()
}

class Solution5472 {
    fun restoreString(s: String, indices: IntArray): String {
        val ans = CharArray(s.length)
        indices.forEachIndexed { index, i ->
            ans[i] = s[index]
        }
        return ans.joinToString("")
    }
}