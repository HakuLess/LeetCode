package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution797()
    s.allPathsSourceTarget(arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3),
            intArrayOf(3),
            intArrayOf()
    )).print()
}

class Solution797 {

    val ans = arrayListOf<ArrayList<Int>>()

    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        if (graph.isEmpty()) {
            return emptyList()
        }
        val target = graph.lastIndex


        val cur = arrayListOf<ArrayList<Int>>()
        graph[0].forEach {
            cur.add(arrayListOf(0, it))
        }

        check(cur, graph, target)
        return ans
    }

    private fun check(cur: ArrayList<ArrayList<Int>>, graph: Array<IntArray>, target: Int) {
        if (cur.isEmpty()) {
            return
        }
        val next = arrayListOf<ArrayList<Int>>()
        cur.forEach {
            if (it.last() == target) {
                ans.add(it)
            } else {
                val item = it.last()
                graph[item].forEach { last ->
                    val array = ArrayList(it)
                    if (last !in array) {
                        array.add(last)
                        next.add(array)
                    }
                }
            }
        }
        check(next, graph, target)
    }
}