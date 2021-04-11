package leetcode.contest.cur.leetcode.c236

import java.util.*
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

//    val pq0 = PriorityQueue<Int>()
//    val pq1 = PriorityQueue<Int>()
//    val pq2 = PriorityQueue<Int>()
//    var sum = 0
//
//    fun addElement(num: Int) {
//        pq0.offer(num)
//        if (pq0.size > k) {
//            val it = pq0.poll()
//            sum += it
//            pq1.offer(it)
//        }
//        if (pq1.size > m - 2 * k) {
//            val it = pq1.poll()
//            sum -= it
//            pq2.offer(it)
//        }
//        if (pq2.size > k) {
//            pq2.poll()
//        }
//    }
//
//    fun calculateMKAverage(): Int {
//        if (pq2.size != k) return -1
//        return sum / (m - 2 * k)
//    }

}