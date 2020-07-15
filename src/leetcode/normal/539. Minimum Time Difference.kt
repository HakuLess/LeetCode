package leetcode.normal

import leetcode.contest.utils.print
import kotlin.math.abs

fun main(args: Array<String>) {
    val array = arrayListOf(
            "01:01", "02:01", "03:00"
    )
    val s = Solution539()
    s.findMinDifference(array).print()
}

class Solution539 {
    fun findMinDifference(timePoints: List<String>): Int {
        var result = 24 * 60
        val intList = timePoints.map {
            val str = it.split(':')
            str[0].toInt() * 60 + str[1].toInt()
        }.sorted()

//        intList.forEach {
//            it.print()
//        }

        for (i in 0 until intList.size - 1) {
            result = minOf(result, abs(intList[i] - intList[i + 1]).minute())
        }
        result = minOf(result, abs(intList.first() - intList.last()).minute())

        return result
    }

    private fun Int.minute(): Int {
        return if (this > 12 * 60) {
            24 * 60 - this
        } else {
            this
        }
    }
}
