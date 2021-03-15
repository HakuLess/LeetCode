package leetcode.contest.last.c232

class Solution5702 {
    fun findCenter(edges: Array<IntArray>): Int {
        return edges[0].toSet().intersect(edges[1].toSet()).first()
    }
}