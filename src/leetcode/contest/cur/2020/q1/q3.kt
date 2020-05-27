package leetcode.contest.cur.`2020`.q1

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    val s = Solutionq3()
//    s.getTriggerTime(
//            arrayOf(
//                    intArrayOf(2, 8, 4),
//                    intArrayOf(2, 5, 0),
//                    intArrayOf(10, 9, 8)
//            ),
//            arrayOf(
//                    intArrayOf(2, 11, 3),
//                    intArrayOf(15, 10, 7),
//                    intArrayOf(9, 17, 12),
//                    intArrayOf(8, 1, 14)
//            )).print()

//    s.getTriggerTime(
//            arrayOf(
//                    intArrayOf(1, 1, 1)
//            ),
//            arrayOf(
//                    intArrayOf(0, 0, 0)
//            )).print()
//
//    s.getTriggerTime(
//            arrayOf(
//                    intArrayOf(0, 4, 5),
//                    intArrayOf(4, 8, 8),
//                    intArrayOf(8, 6, 1),
//                    intArrayOf(10, 10, 0)
//            ),
//            arrayOf(
//                    intArrayOf(12, 11, 16),
//                    intArrayOf(20, 2, 6),
//                    intArrayOf(9, 2, 6),
//                    intArrayOf(10, 18, 3),
//                    intArrayOf(8, 14, 9)
//            )).print()
    s.getTriggerTime(
            arrayOf(
                    intArrayOf(6, 3, 4),
                    intArrayOf(6, 7, 2)
            ),
            arrayOf(
                    intArrayOf(0, 13, 14),
                    intArrayOf(0, 5, 5),
                    intArrayOf(0, 4, 18),
                    intArrayOf(4, 3, 4)
            )).print()
}

// Should Use BIS
class Solutionq3 {

    fun getTriggerTime(increase: Array<IntArray>, requirements: Array<IntArray>): IntArray {
        val ans = IntArray(requirements.size) { -1 }
        val visited = BooleanArray(requirements.size)
        val sum = Array(increase.size + 1) {
            IntArray(3)
        }
        for (i in increase.size - 1 downTo 0) {
            for (j in i downTo 0) {
                for (k in 0..2) {
                    sum[i + 1][k] += increase[j][k]
                }
            }
        }

        for ((i, req) in requirements.withIndex()) {
            for (j in sum.size - 1 downTo 0) {
                var start = true
                for (k in 0..2) {
                    if (req[k] > sum[j][k]) {
                        start = false
                    }
                }
                if (!start) {
                    break
                }
                ans[i] = j
            }
        }
        return ans
    }

//    fun getTriggerTime(increase: Array<IntArray>, requirements: Array<IntArray>): IntArray {
//
//        var pq0 = ArrayList<IntArray>()
//        var pq1 = ArrayList<IntArray>()
//        var pq2 = ArrayList<IntArray>()
//
//        requirements.forEachIndexed { index, ints ->
//            pq0.add(intArrayOf(ints[0], index))
//            pq1.add(intArrayOf(ints[1], index))
//            pq2.add(intArrayOf(ints[2], index))
//        }
//
//        pq0.sortBy { it[0] }
//        pq1.sortBy { it[0] }
//        pq2.sortBy { it[0] }
//
//        val cur = intArrayOf(0, 0, 0)
//        val ans = IntArray(requirements.size) { -1 }
//
//        val a0 = IntArray(requirements.size) { -1 }
//        val a1 = IntArray(requirements.size) { -1 }
//        val a2 = IntArray(requirements.size) { -1 }
//
//        for (j in 0..increase.size) {
//            val it = if (j != increase.size) increase[j] else intArrayOf(0, 0, 0)
//            while (pq0.isNotEmpty() && pq0[0][0] <= cur[0]) {
//                a0[pq0[0][1]] = j
//                pq0.removeAt(0)
//            }
//            while (pq1.isNotEmpty() && pq1[0][0] <= cur[1]) {
//                a1[pq1[0][1]] = j
//                pq1.removeAt(0)
//            }
//            while (pq2.isNotEmpty() && pq2[0][0] <= cur[2]) {
//                a2[pq2[0][1]] = j
//                pq2.removeAt(0)
//            }
//            for (i in 0..2) {
//                cur[i] += it[i]
//            }
//        }
//        for (i in ans.indices) {
//            val t = arrayOf(a0[i], a1[i], a2[i])
//            if (t.all { it == 0 }) ans[i] = 0
//            else
//                ans[i] = if (t.any { it == -1 }) -1 else t.max()!!
//        }
//        a0.print()
//        a1.print()
//        a2.print()
//        return ans
//    }
}