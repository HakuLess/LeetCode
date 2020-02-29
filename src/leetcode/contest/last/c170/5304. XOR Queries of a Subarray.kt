package leetcode.contest.last.c170

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5304()
    s.xorQueries(intArrayOf(1, 3, 4, 8), arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(0, 3), intArrayOf(3, 3))).print()
}

class Solution5304 {
    fun xorQueries(arr: IntArray, queries: Array<IntArray>): IntArray {
        val ans = ArrayList<Int>()
        queries.forEach {
            var item = arr[it[0]]
            for (j in (it[0] + 1)..it[1]) {
                item = item xor arr[j]
            }
            ans.add(item)
        }
        return ans.toIntArray()
    }
}