package leetcode.contest.cur.leetcode.c205

import leetcode.contest.utils.UFS

class Solution5510 {
    fun maxNumEdgesToRemove(n: Int, edges: Array<IntArray>): Int {
        val ufs0 = UFS(n)
        val ufs1 = UFS(n)
        var ans = 0
        edges.forEach {
            if (it[0] == 3) {
                if (!ufs0.union(it[1] - 1, it[2] - 1)) {
                    ans++
                }
                ufs1.union(it[1] - 1, it[2] - 1)
            }
        }
        edges.forEach {
            if (it[0] == 1) {
                if (!ufs0.union(it[1] - 1, it[2] - 1)) {
                    ans++
                }
            }
        }
        edges.forEach {
            if (it[0] == 2) {
                if (!ufs1.union(it[1] - 1, it[2] - 1)) {
                    ans++
                }
            }
        }
        for (i in 1 until n) {
            if (ufs0.find(i) != ufs0.find(0) || ufs1.find(i) != ufs1.find(0)) return -1
        }
        return ans
    }
}