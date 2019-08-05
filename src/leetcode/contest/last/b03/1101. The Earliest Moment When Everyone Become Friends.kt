package leetcode.contest.last.b03

import leetcode.UFS

class Solution1101 {
    fun earliestAcq(logs: Array<IntArray>, N: Int): Int {
        logs.sortBy { it[0] }
        val ufs = UFS(N)
        logs.forEach {
            ufs.union(it[1], it[2])
            if (allF(ufs, N)) {
                return it[0]
            }
        }
        return -1
    }

    private fun allF(ufs: UFS, n: Int): Boolean {
        val a = ufs.find(0)
        for (i in 0 until n) {
            if (a != ufs.find(i)) {
                return false
            }
        }
        return true
    }


}