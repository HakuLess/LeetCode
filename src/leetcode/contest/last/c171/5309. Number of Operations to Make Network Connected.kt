package leetcode.contest.last.c171

import leetcode.contest.utils.UFS

fun main(args: Array<String>) {
    val s = Solution5309()
    s.makeConnected(4, arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3), intArrayOf(1, 3)))
}

class Solution5309 {
    fun makeConnected(n: Int, connections: Array<IntArray>): Int {
        if (connections.size < n - 1) {
            return -1
        }
        val ufs = UFS(n)
        var ans = 0
        connections.forEach {
            if (ufs.union(it[0], it[1])) {
                ans++
            }
        }
        return n - ans - 1
    }
}