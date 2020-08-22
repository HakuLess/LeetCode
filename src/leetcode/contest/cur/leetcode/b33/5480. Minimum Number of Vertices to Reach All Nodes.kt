package leetcode.contest.cur.leetcode.b33

class Solution5480 {
    fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {
        val ans = arrayListOf<Int>()
        val set = edges.map {
            it[1]
        }.toSet()
        for (i in 0 until n) {
            if (i !in set) {
                ans.add(i)
            }
        }
        return ans
    }
}