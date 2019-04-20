package leetcode.normal

import java.util.ArrayList


fun main(args: Array<String>) {
    val c = MyCalendarTwo()
    println("36, 41 " + c.book(36, 41))
    println("28, 34 " + c.book(28, 34))
    println("40, 46 " + c.book(40, 46))
    println("25, 34 " + c.book(40, 46))
    println("36, 44 " + c.book(36, 44))
    println("32, 40 " + c.book(32, 40))
    println("34, 39 " + c.book(34, 39))
    println("40, 49 " + c.book(40, 49))
}

class MyCalendarTwo internal constructor() {
    var calendar: MutableList<IntArray> = ArrayList()
    var overlaps: MutableList<IntArray> = ArrayList()

    fun book(start: Int, end: Int): Boolean {
        for (iv in overlaps) {
            if (iv[0] < end && start < iv[1]) return false
        }
        for (iv in calendar) {
            if (iv[0] < end && start < iv[1])
                overlaps.add(intArrayOf(Math.max(start, iv[0]), Math.min(end, iv[1])))
        }
        calendar.add(intArrayOf(start, end))
        return true
    }
}