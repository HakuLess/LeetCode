package leetcode.contest.cur.leetcode.b33

class Solution5480 {
    fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {
        val set = edges.map {
            it[1]
        }.toSet()
        return (0 until n).filter {
            it !in set
        }
    }
}