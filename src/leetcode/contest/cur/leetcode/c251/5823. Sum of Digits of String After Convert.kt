package leetcode.contest.cur.leetcode.c251

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5823()
    s.getLucky("zbax", 2).print()
}

class Solution5823 {
    fun getLucky(s: String, k: Int): Int {
        var c = s.map { (it - 'a' + 1).toString() }.joinToString("")
        repeat(k) {
            c = c.map { it - '0' }.sum().toString()
        }
        return c.toInt()
    }
}