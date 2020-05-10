package leetcode.contest.last.c179

import leetcode.contest.utils.print
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    val s = Solution5354()
    s.numOfMinutes(15, 0,
            intArrayOf(-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6),
            intArrayOf(1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0)).print()
}

class Solution5354 {
    var max = 0
    fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray): Int {
        if (n == 1) {
            return 0
        }
        val map = HashMap<Int, ArrayList<Int>>()
        for (i in manager.indices) {
            map[manager[i]] = map.getOrDefault(manager[i], arrayListOf())
            map[manager[i]]!!.add(i)
        }
        dfs(headID, map, informTime, 0)
        return max
    }

    private fun dfs(headID: Int, map: HashMap<Int, ArrayList<Int>>, informTime: IntArray, cost: Int) {
        max = maxOf(max, cost)

        map[headID]?.forEach {
            dfs(it, map, informTime, cost + informTime[headID])
        }
    }
}