package leetcode.normal

import leetcode.contest.utils.print
import java.util.*
import kotlin.math.max

fun main(args: Array<String>) {
    val s = Solution57()
//    s.insert(arrayOf(intArrayOf(1, 3), intArrayOf(6, 9)), intArrayOf(2, 5)).print()
    s.insert(arrayOf(intArrayOf(1, 2),
            intArrayOf(3, 5),
            intArrayOf(6, 7),
            intArrayOf(8, 10),
            intArrayOf(12, 16)
    ),
            intArrayOf(4, 8)).print()
}

class Solution57 {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val pre = arrayListOf<IntArray>()
        val suf = arrayListOf<IntArray>()
        val merge = arrayListOf<IntArray>()
        intervals.sortBy { it[0] }
        intervals.forEach {
            when {
                it[1] < newInterval[0] -> {
                    pre.add(it)
                }
                it[0] > newInterval[1] -> {
                    suf.add(it)
                }
                else -> {
                    merge.add(it)
                }
            }
        }
        merge.add(newInterval)
        val ans = arrayListOf<IntArray>()
        ans.addAll(pre)
        ans.addAll(merge(merge.toTypedArray()))
        ans.addAll(suf)
        return ans.toTypedArray()
    }

    private fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }
        val merged = LinkedList<IntArray>()
        for (interval in intervals) {
            if (merged.isEmpty() || merged.last[1] < interval[0]) {
                merged.add(interval)
            } else {
                merged.last[1] = maxOf(merged.last[1], interval[1])
            }
        }
        return merged.toTypedArray()
    }
}