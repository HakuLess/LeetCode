package leetcode.contest.cur.c192

import leetcode.contest.utils.print
import kotlin.math.abs

fun main(args: Array<String>) {
    val s = Solution5429()
//    s.getStrongest(intArrayOf(1, 2, 3, 4, 5), 2).print()
    s.getStrongest(intArrayOf(6, 7, 11, 7, 6, 8), 5).print()

}

class Solution5429 {
    fun getStrongest(arr: IntArray, k: Int): IntArray {
        arr.sort()
        val mid = arr[(arr.size - 1) / 2]
        val sorted = arr.sortedWith(compareBy(
                { abs(it - mid) }, { it }))
        return sorted.takeLast(k).toIntArray()
    }
}