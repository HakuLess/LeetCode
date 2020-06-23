package leetcode.normal

import leetcode.contest.utils.print
import java.util.TreeMap

fun main(args: Array<String>) {
    val s = MyCalendarThree()
    s.book(10, 20).print()
    s.book(50, 60).print()
    s.book(10, 40).print()
    s.book(5, 15).print()
    s.book(5, 10).print()
    s.book(25, 55).print()
}

class MyCalendarThree {

    fun book(start: Int, end: Int): Int {
        return 1
    }
}

//class MyCalendarThree {
//    private val delta: TreeMap<Int, Int> = TreeMap()
//
//    fun book(start: Int, end: Int): Int {
//        delta[start] = delta.getOrDefault(start, 0) + 1
//        delta[end] = delta.getOrDefault(end, 0) - 1
//
//        var active = 0
//        var ans = 0
//        for (d in delta.values) {
//            active += d
//            if (active > ans) ans = active
//        }
//        delta.print()
//        return ans
//    }
//}