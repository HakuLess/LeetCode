package leetcode.contest.cur.leetcode.c207

import leetcode.contest.utils.multi
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5519()
    s.reorderSpaces("  this   is  a sentence ").print()
}

class Solution5519 {
    fun reorderSpaces(text: String): String {
        val res = text.split(' ').filter { it.isNotEmpty() }
//        res.joinToString(",").print()
        val count = text.count { it == ' ' }
        if (res.size == 1) {
            return res[0] + " ".multi(count)
        }
        val a = count / (res.size - 1)
        val b = count % (res.size - 1)
        return res.joinToString(separator = " ".multi(a), postfix = " ".multi(b))
    }
}