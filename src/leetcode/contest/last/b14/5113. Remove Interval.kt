package leetcode.contest.last.b14

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5113()
    s.removeInterval(arrayOf(
            intArrayOf(0, 2),
            intArrayOf(3, 4),
            intArrayOf(5, 7)
    ), intArrayOf(1, 6)).print()

    s.removeInterval(arrayOf(
            intArrayOf(0, 5)
    ), intArrayOf(2, 3)).print()
}

class Solution5113 {
    fun removeInterval(intervals: Array<IntArray>, toBeRemoved: IntArray): List<List<Int>> {
        val pre = arrayListOf<IntArray>()
        val suf = arrayListOf<IntArray>()
        val deleted = arrayListOf<IntArray>()
        intervals.sortBy { it[0] }
        intervals.forEach {
            when {
                it[1] < toBeRemoved[0] -> {
                    pre.add(it)
                }
                it[0] > toBeRemoved[1] -> {
                    suf.add(it)
                }
                else -> {
                    deleted.add(it)
                }
            }
        }
        val ans = arrayListOf<IntArray>()
        ans.addAll(pre)
        ans.addAll(delete(deleted.toTypedArray(), toBeRemoved))
        ans.addAll(suf)
        return ans.map {
            it.toArrayList()
        }
    }

    private fun delete(intervals: Array<IntArray>, toBeRemoved: IntArray): Array<IntArray> {
        intervals.sortBy { it[0] }
        val delete = LinkedList<IntArray>()
        for (interval in intervals) {
            if (toBeRemoved[0] > interval[0] && toBeRemoved[1] >= interval[1]) {
                delete.add(intArrayOf(interval[0], toBeRemoved[0]))
            } else if (toBeRemoved[0] <= interval[0] && toBeRemoved[1] < interval[1]) {
                delete.add(intArrayOf(toBeRemoved[1], interval[1]))
            } else if (toBeRemoved[0] > interval[0] && toBeRemoved[1] < interval[1]) {
                delete.add(intArrayOf(interval[0], toBeRemoved[0]))
                delete.add(intArrayOf(toBeRemoved[1], interval[1]))
            }
        }
        return delete.toTypedArray()
    }

    inline fun IntArray.toArrayList(): ArrayList<Int> {
        val ans = ArrayList<Int>()
        this.forEach {
            ans.add(it)
        }
        return ans
    }
}