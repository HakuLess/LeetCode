package leetcode.contest.last.c170

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5304()
    s.xorQueries(intArrayOf(1, 3, 4, 8), arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(0, 3), intArrayOf(3, 3))).print()
}

class Solution5304 {
    fun xorQueries(arr: IntArray, queries: Array<IntArray>): IntArray {
        val pre = IntArray(arr.size + 1)
        pre[0] = 0
        for (i in arr.indices) {
            pre[i + 1] = pre[i] xor arr[i]
        }
        val ans = ArrayList<Int>()
        queries.forEach {
            ans.add(pre[it[0]] xor pre[it[1] + 1])
        }
        return ans.toIntArray()
    }
}