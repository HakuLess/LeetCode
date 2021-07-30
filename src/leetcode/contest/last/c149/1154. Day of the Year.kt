package leetcode.contest.last.c149

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution1154()
    s.dayOfYear("2019-02-10").print()
    s.dayOfYear("2004-03-01").print()
}
class Solution1154 {
    fun dayOfYear(date: String): Int {
        val c = Calendar.getInstance()
        val a = date.split("-")
        c.set(a[0].toInt(), a[1].toInt() - 1, a[2].toInt())
        return c.get(Calendar.DAY_OF_YEAR)
    }
}