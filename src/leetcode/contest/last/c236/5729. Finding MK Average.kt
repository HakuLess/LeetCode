package leetcode.contest.last.c236

import leetcode.contest.utils.MultiSet
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = MKAverage(3, 1)
    s.addElement(3)
    s.addElement(1)
    s.calculateMKAverage().print()
    s.addElement(10)
    s.calculateMKAverage().print()
    s.addElement(5)
    s.addElement(5)
    s.addElement(5)
    s.calculateMKAverage().print()
}

class MKAverage(val m: Int, val k: Int) {

    val left = MultiSet<Int> { it }
    val mid = MultiSet<Int> { it }
    val right = MultiSet<Int> { it }
    val all = arrayListOf<Int>()

    fun addElement(num: Int) {
        if (all.size == m) {
            val it = all.removeAt(0)
            when {
                it <= left.max -> {
                    left.remove(it)
                }
                it <= mid.max -> {
                    mid.remove(it)
                }
                else -> {
                    right.remove(it)
                }
            }
            if (left.size < k) {
                left.add(mid.popLeft())
            }
            if (mid.size < m - 2 * k) {
                mid.add(right.popLeft())
            }
        }

        all.add(num)
        left.add(num)
        if (left.size > k) {
            mid.add(left.popRight())
        }
        if (mid.size > m - 2 * k) {
            right.add(mid.popRight())
        }
    }

    fun calculateMKAverage(): Int {
        if (all.size != m) return -1
        return (mid.sum / mid.size).toInt()
    }
}

//class MKAverage(val m: Int, val k: Int) {
//
//    val total = arrayListOf<Int>()
//    val pq0 = PriorityQueue<Int>()
//    val pq1 = PriorityQueue<Int>(compareByDescending { it })
//    val pq2 = PriorityQueue<Int>(compareByDescending { it })
//    val pq3 = PriorityQueue<Int>()
//    var sum0 = 0L
//    var sum1 = 0L
//    var sum2 = 0L
//
//    fun addElement(num: Int) {
//        total.add(num)
//        sum0 += num
//        if (total.size > m) {
//            val it = total.removeAt(0)
//            sum0 -= it
//            if (!pq2.remove(it)) {
//                sum1 -= it
//                pq0.remove(it)
//                val poll = pq2.poll()
//                sum1 += poll
//                pq0.offer(poll)
//            }
//            if (!pq3.remove(it)) {
//                sum2 -= it
//                pq1.remove(it)
//                val poll = pq3.poll()
//                sum2 += poll
//                pq1.offer(poll)
//            }
//        }
//
//        pq0.offer(num)
//        sum1 += num
//        if (pq0.size > k) {
//            val it = pq0.poll()
//            pq2.offer(it)
//            sum1 -= it
//        }
//
//        pq1.offer(num)
//        sum2 += num
//        if (pq1.size > k) {
//            val it = pq1.poll()
//            pq3.offer(it)
//            sum2 -= it
//        }
//    }
//
//    fun calculateMKAverage(): Int {
//        if (total.size != m) return -1
//        return ((sum0 - sum1 - sum2) / (m - 2 * k)).toInt()
//    }
//
//}

//class MKAverage(val m: Int, val k: Int) {
//
//    val l = ArrayList<Int>()
//
//    fun addElement(num: Int) {
//        l.add(num)
//        if (l.size > m) {
//            l.removeAt(0)
//        }
//    }
//
//    fun calculateMKAverage(): Int {
//        if (l.size < m) return -1
//        val c = l.clone() as ArrayList<Int>
//        c.sort()
//        return c.drop(k).dropLast(k).average().toInt()
//    }
//
//}