package leetcode.contest.last.c155

import leetcode.contest.utils.Graph
import leetcode.contest.utils.print
import leetcode.contest.utils.topologicalSort

/**
 * 拓扑排序
 * */
fun main(args: Array<String>) {
    val s = Solution5200()
    s.sortItems(8, 2, intArrayOf(-1, -1, 1, 0, 0, 1, 0, -1),
            listOf(listOf(), listOf(6), listOf(5), listOf(6), listOf(3, 6), listOf(), listOf(), listOf())
    ).print()
}

class Solution5200 {
    fun sortItems(n: Int, m: Int, group: IntArray, beforeItems: List<List<Int>>): IntArray {

        val groupItems = ArrayList<ArrayList<Int>>()
        for (i in 0 until m) {
            groupItems.add(arrayListOf())
        }
        for (i in 0 until group.size) {
            if (group[i] >= 0) {
                groupItems[group[i]].add(i)
            } else {
                groupItems.add(arrayListOf(i))
                group[i] = groupItems.lastIndex
            }
        }

        val graphList = ArrayList<Graph>()
        for (i in 0 until groupItems.size) {
            graphList.add(Graph(groupItems[i].size))
        }
        val groupGraph = Graph(groupItems.size)

        for (i in 0 until n) {
            beforeItems[i].forEach {
                val gi = group[i]
                if (gi == group[it]) {
                    // same group
                    graphList[gi].addEdgeOri(groupItems[gi].indexOf(it), groupItems[gi].indexOf(i))
                } else {
                    groupGraph.addEdgeOri(group[it], gi)
                }
            }
        }

        val ans = arrayListOf<Int>()
        val gs = groupGraph.topologicalSort()
        if (gs.size < groupItems.size) {
            return intArrayOf()
        }
        gs.forEach {
            val cur = graphList[it].topologicalSort()
            if (cur.size < groupItems[it].size) {
                return intArrayOf()
            }
            ans.addAll(cur.map { index ->
                groupItems[it][index]
            })
        }
        return ans.toIntArray()
    }
}