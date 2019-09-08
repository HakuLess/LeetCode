package leetcode.contest.cur.c153

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5183()
    s.dayOfTheWeek(31,8,2019).print()
    s.dayOfTheWeek(18,7,1999).print()
    s.dayOfTheWeek(15,8,1993).print()
}

class Solution5183 {
    fun dayOfTheWeek(day: Int, month: Int, year: Int): String {
        val c = Calendar.getInstance()
        c.set(year, month - 1, day)
        val ans = c.get(Calendar.DAY_OF_WEEK)
        val array = arrayOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
        return array[ans - 1]
    }
}