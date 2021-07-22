package leetcode.contest.last.c250

import leetcode.contest.utils.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    val s = Solution5816()
    s.maxGeneticDifference(intArrayOf(-1, 0, 1, 1), "[[0,2],[3,2],[2,5]]".toGrid()).print()
    s.maxGeneticDifference(intArrayOf(3, 3, 3, -1, 3), "[[2,6],[2,1],[1,9],[2,3],[3,6]]".toGrid()).print()
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

        fun dfs(cur: Int, trie: Trie<Int>) {
            queryMap[cur]?.forEach {
                ans[it.second] = trie.maxXor(it.first)
            }
            map[cur]?.forEach {
                trie.insertInt(it)
                dfs(it, trie)
                trie.removeInt(it)
            }
        }

        dfs(-1, Trie<Int>())

        return ans
    }
}