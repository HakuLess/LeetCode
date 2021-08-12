package leetcode.contest.last.c176

import leetcode.contest.utils.print
import java.util.*


fun main(args: Array<String>) {
    val s = Solution5342()
    s.maxEvents(arrayOf(intArrayOf(1, 1), intArrayOf(1, 2), intArrayOf(1, 3))).print()
    s.maxEvents(arrayOf(intArrayOf(1, 5), intArrayOf(1, 5), intArrayOf(1, 5), intArrayOf(2, 3), intArrayOf(2, 3))).print()
    s.maxEvents(arrayOf(intArrayOf(1, 4), intArrayOf(4, 4), intArrayOf(2, 2), intArrayOf(3, 4), intArrayOf(1, 1))).print()

}

class Solution5342 {
//    fun maxEvents(events: Array<IntArray>): Int {
//        val sorted = events.sortedWith(compareBy({ it[1] }, { it[0] }))
//        var ans = 0
//        val seen = HashSet<Int>()
//        sorted.forEach {
//            for (i in it[0]..it[1]) {
//                if (seen.add(i)) {
//                    ans++
//                    break
//                }
//            }
//        }
//        return ans
//    }

    fun maxEvents(events: Array<IntArray>): Int {
        val n = events.size
        val sorted = events.sortedBy { it[0] }
        var p = 0
        var ans = 0
        val pq = PriorityQueue<Int>()
        for (day in 1..100000) {
            while (p < n && sorted[p][0] == day) {
                pq.add(sorted[p][1])
                p++
            }
            while (!pq.isEmpty()) {
                val cur = pq.poll()
                if (cur < day) continue
                ans++
                break
            }
        }
        return ans
    }

//
//    fun maxEvents(events: Array<IntArray>): Int {
//
//        var c = clone(events)
//        var cur = c.minByOrNull { it[0] }!![0]
//        var ans = 0
//        while (c.isNotEmpty()) {
//            c = ArrayList(c.filter { it[1] >= cur })
//            if (c.isEmpty()) {
//                return ans
//            }
////            c.toTypedArray().print()
//            c.forEach {
//                if (it[0] < cur) {
//                    it[0] = cur
//                }
//            }
//            c.sortWith(compareBy({ it[0] }, { it[1] }))
//            ans++
//            c[0].print()
//            c.removeAt(0)
//            if (c.isEmpty()) {
//                return ans
//            }
//            cur = maxOf(cur + 1, c.minByOrNull { it[0] }!![0])
//        }
//        return ans
//    }

    //    private fun helper(events: Array<IntArray>, cur: Int): Int {
//        if (events.isEmpty()) {
//            return 0
//        }
//        var max = 0
//        events.forEachIndexed { index, ints ->
//            val c = clone(events)
//            if (cur in ints[0]..ints[1]) {
//                c.remove(ints)
//                max = if (c.isEmpty()) {
//                    maxOf(max, 1)
//                } else {
//                    maxOf(max, 1 + helper(c.toTypedArray(), maxOf(1 + cur, c.minByOrNull { it[0] }!![0])))
//                }
//                c.add(ints)
//            }
//        }
//        return max
//    }
//
//    private fun clone(array: Array<IntArray>): ArrayList<IntArray> {
//        val ans = arrayListOf<IntArray>()
//        array.forEachIndexed { index, ints ->
//            ans.add(ints)
//        }
//        return ans
//    }
}