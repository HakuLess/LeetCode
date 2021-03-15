package leetcode.contest.last.b43

import leetcode.contest.utils.*
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val s = Solution5636()
//    s.checkWays("[[1,2],[2,3]]".toGrid()).print()
//    s.checkWays("[[1,2],[2,3],[1,3]]".toGrid()).print()
//    s.checkWays("[[1,2],[2,3],[2,4],[1,5]]".toGrid()).print()
    s.checkWays("[[1,5],[1,3],[2,3],[2,4],[3,5],[3,4]]".toGrid()).print()
//    s.checkWays("[[4,5],[3,4],[2,4]]".toGrid()).print()
}

class Solution5636 {
    fun checkWays(pairs: Array<IntArray>): Int {
        val map = hashMapOf<Int, HashSet<Int>>()
        val matrix = Array<BooleanArray>(501) { BooleanArray(501) { false } }
        pairs.forEach {
            map[it[0]] = map.getOrDefault(it[0], HashSet())
            map[it[0]]!!.add(it[1])
            map[it[1]] = map.getOrDefault(it[1], HashSet())
            map[it[1]]!!.add(it[0])
            matrix[it[0]][it[1]] = true
            matrix[it[1]][it[0]] = true
        }
        val nodes = arrayListOf<Int>()
        nodes.addAll(map.keys)
        nodes.sortByDescending { map[it]!!.size }

        val n = map.keys.size
        if (map[nodes[0]]!!.size != n - 1) return 0
        var ans = 1
        for (i in 0 until n) {
            val k = map[nodes[i]]!!.size
            for (node in map[nodes[i]]!!) {
                if (map[node]!!.size == k) {
                    ans = 2
                }
                map[node]!!.remove(nodes[i])
                for (it in map[node]!!) {
                    if (!matrix[it][nodes[i]])
                        return 0
                }
            }
        }
        return ans
    }
}