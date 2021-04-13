package leetcode.contest.cur.leetcode.c236

import kotlin.collections.ArrayList

class MKAverage(val m: Int, val k: Int) {

    val l = ArrayList<Int>()

    fun addElement(num: Int) {
        l.add(num)
        if (l.size > m) {
            l.removeAt(0)
        }
    }

    fun calculateMKAverage(): Int {
        if (l.size < m) return -1
        val c = l.clone() as ArrayList<Int>
        c.sort()
        return c.drop(k).dropLast(k).average().toInt()
    }

}