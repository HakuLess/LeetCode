package leetcode.contest.cur.leetcode.c232

class Solution5702 {
    fun findCenter(edges: Array<IntArray>): Int {
        val set = HashSet(edges[0].toSet())
        edges.forEach { arr ->
            set.removeAll { it !in arr }
            if (set.size == 1) return set.first()
        }
        return -1
    }
}