package leetcode.contest.cur.leetcode.b43

import leetcode.contest.utils.*

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
        val map = hashMapOf<Int, ArrayList<Int>>()
        pairs.forEach {
            map[it[0]] = map.getOrDefault(it[0], arrayListOf())
            map[it[0]]!!.add(it[1])
            map[it[1]] = map.getOrDefault(it[1], arrayListOf())
            map[it[1]]!!.add(it[0])
        }
        val nodes = arrayListOf<Int>()
        nodes.addAll(map.keys)
        nodes.sortByDescending { map[it]!!.size }

        val n = map.keys.size
        if (map[nodes[0]]!!.size != n - 1) return 0
        var ans = 1
        var start = 1
        while (start < n && map[nodes[start]]!!.size == n - 1) {
            ans = 2
            start += 1
        }
        for (i in 0 until start) {
            for (node in map[nodes[i]]!!) {
                map[node]!!.remove(nodes[i])
            }
        }
        for (i in start until n) {
            val k = map[nodes[i]]!!.size
            for (node in map[nodes[i]]!!) {
                if (map[node]!!.size == k) {
                    ans = 2
                }
                map[node]!!.remove(nodes[i])
                if (k < map[nodes[i]]!!.union(map[node]!!).size)
                    return 0
            }
        }
        return ans
    }
}