package leetcode.contest.last.c177

import leetcode.contest.utils.print
import java.text.SimpleDateFormat
import java.util.*


fun main(args: Array<String>) {
    val s = Solution5169()
    s.daysBetweenDates("2019-06-29", "2019-06-30").print()
    s.daysBetweenDates("2020-01-15", "2019-12-31").print()
}

class Solution5169 {
    fun daysBetweenDates(date1: String, date2: String): Int {
        val format = SimpleDateFormat("yyyy-MM-dd")
        val array = arrayOf(date1, date2).sortedArray()
        val d1 = format.parse(array[0])
        val d2 = format.parse(array[1])

        val cal1 = Calendar.getInstance()
        cal1.time = d1

        val cal2 = Calendar.getInstance()
        cal2.time = d2
        val day1 = cal1[Calendar.DAY_OF_YEAR]
        val day2 = cal2[Calendar.DAY_OF_YEAR]

        val year1 = cal1[Calendar.YEAR]
        val year2 = cal2[Calendar.YEAR]
        return if (year1 != year2) {
            var timeDistance = 0
            for (i in year1 until year2) {
                timeDistance += if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                    366
                } else {
                    365
                }
            }
            timeDistance + (day2 - day1)
        } else {
            day2 - day1
        }
    }
}