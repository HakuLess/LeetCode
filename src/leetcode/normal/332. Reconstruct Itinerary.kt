package leetcode.normal

import java.util.*
import kotlin.collections.HashMap


class Solution332 {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val map = HashMap<String, PriorityQueue<String>>()
        val ans = arrayListOf<String>()

        fun dfs(cur: String) {
            println("dfs $cur")
            while (map.containsKey(cur) && map[cur]!!.size > 0) {
                dfs(map[cur]!!.poll())
            }
            ans.add(0, cur)
        }

        for (ticket in tickets) {
            val src = ticket[0]
            val dst = ticket[1]
            if (!map.containsKey(src)) {
                map[src] = PriorityQueue()
            }
            map[src]!!.offer(dst)
        }
        dfs("JFK")
        return ans
    }
}