package leetcode.contest.cur.leetcode.c250

import leetcode.contest.utils.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    val s = Solution5816()
    s.maxGeneticDifference(intArrayOf(-1, 0, 1, 1), "[[0,2],[3,2],[2,5]]".toGrid()).print()
}

// 字典树Remove！
class Solution5816 {
    fun maxGeneticDifference(parents: IntArray, queries: Array<IntArray>): IntArray {
        val map = HashMap<Int, ArrayList<Int>>()
        for (i in parents.indices) {
            map[parents[i]] = map.getOrDefault(parents[i], arrayListOf())
            map[parents[i]]!!.add(i)
        }

        val queryMap = HashMap<Int, ArrayList<Pair<Int, Int>>>()
        for (i in queries.indices) {
            queryMap[queries[i][0]] = queryMap.getOrDefault(queries[i][0], arrayListOf())
            queryMap[queries[i][0]]!!.add(Pair(queries[i][1], i))
        }

        val ans = IntArray(queries.size)

        fun dfs(cur: Int, list: ArrayList<Int>) {
            if (cur != -1)
                list.add(cur)
            map[cur]?.forEach {
                dfs(it, list)
            }
            queryMap[cur]?.forEach {
                val trie = Trie<Int>()
                list.joinToString().print()
                list.forEach {
                    trie.insertInt(it)
                }
                ans[it.second] = trie.maxXor(it.first)
            }
            if (cur != -1)
                list.remove(cur)
        }

        dfs(-1, arrayListOf())

        return ans
    }
}