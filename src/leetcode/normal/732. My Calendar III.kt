package leetcode.normal

import java.util.TreeMap


internal class MyCalendarThree {
    private val delta: TreeMap<Int, Int> = TreeMap()

    fun book(start: Int, end: Int): Int {
        delta[start] = delta.getOrDefault(start, 0) + 1
        delta[end] = delta.getOrDefault(end, 0) - 1

        var active = 0
        var ans = 0
        for (d in delta.values) {
            active += d
            if (active > ans) ans = active
        }
        return ans
    }
}