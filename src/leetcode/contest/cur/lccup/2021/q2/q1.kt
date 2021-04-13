package leetcode.contest.cur.lccup.`2021`.q2

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solutionq1()
    s.storeWater(intArrayOf(1, 3), intArrayOf(6, 8)).print()
    s.storeWater(intArrayOf(9, 0, 1), intArrayOf(0, 2, 2)).print()
//    s.get(1, 10000).print()
}

class Solutionq1 {
    fun storeWater(bucket: IntArray, vat: IntArray): Int {
        if (vat.all { it == 0 }) return 0
        val pq = PriorityQueue<IntArray>(compareByDescending {
            (it[1] - 1) / it[0] + 1
        })
        for (i in bucket.indices) {
            if (bucket[i] == 0) {
                pq.offer(intArrayOf(1, vat[i], 1, i))
            } else {
                pq.offer(intArrayOf(bucket[i], vat[i], 0, i))
            }
        }
        val ans = IntArray(bucket.size) { Int.MAX_VALUE }
        var res = Int.MAX_VALUE
        while (pq.isNotEmpty()) {
            val it = pq.poll()
            ans[it[3]] = minOf(ans[it[3]], (it[1] - 1) / it[0] + 1 + it[2])
            if (it[0] < it[1]) {
                pq.offer(intArrayOf(it[0] + 1, it[1], it[2] + 1, it[3]))
            }
            res = minOf(res, ans.max()!!)
        }
        return res
    }
}