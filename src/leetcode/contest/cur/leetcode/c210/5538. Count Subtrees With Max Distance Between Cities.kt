package leetcode.contest.cur.leetcode.c210

import leetcode.contest.utils.TypedUFS
import leetcode.contest.utils.UFS
import leetcode.contest.utils.print
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val s = Solution5538()
    s.countSubgraphsForEachDiameter(4,
            arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(2, 4)
            )).print()

    s.countSubgraphsForEachDiameter(4,
            arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(1, 4),
                    intArrayOf(2, 3)
            )).print()

//    for (i in 0..7) {
//        for (j in 0..2) {
//            println("$i, ${1 shl j}")
//            if (i and (1 shl j) != 0) {
//                println("state ${i} add $j")
//            }
//        }
//    }
}

class Solution5538 {
    fun countSubgraphsForEachDiameter(n: Int, edges: Array<IntArray>): IntArray {
        val r = n - 1
        val ans = IntArray(r)
        val set = HashSet<IntArray>()

        fun check(state: Int) {
            val ufs = TypedUFS<Int>(n)
            set.clear()
            for (i in edges.indices) {
                if (state and (1 shl i) != 0) {
                    ufs.union(edges[i][0], edges[i][1])
                    set.add(edges[i])
                }
            }
            var cur = -1
            set.forEach {
                if (cur == -1) {
                    cur = ufs.typedFind(it[0])
                }
                if (ufs.typedFind(it[0]) != cur || ufs.typedFind(it[1]) != cur) {
                    return
                }
            }
//            if (ufs.size != n - Integer.bitCount(state)) {
//                return
//            }
            val dia = treeDiameter(set.toTypedArray())
            if (dia - 1 in ans.indices) {
                ans[dia - 1]++
            }
        }

        for (state in 0 until (1 shl r)) {
            check(state)
        }
        return ans
    }

    private var ans = 0
    private var list = HashMap<Int, ArrayList<Int>>()
    private var isVisited = HashSet<Int>()

    fun treeDiameter(edges: Array<IntArray>): Int {
        list.clear()
        ans = 0
        if (edges.isEmpty()) return 0
        val n = edges.size + 1
        isVisited.clear()
        for (i in edges.indices) {
            val u = edges[i][0]
            val v = edges[i][1]
            val a = list.getOrDefault(u, arrayListOf())
            list[u] = a
            list[u]!!.add(v)

            val b = list.getOrDefault(v, arrayListOf())
            list[v] = b
            list[v]!!.add(u)
        }
        dfs(edges[0][0])
        return ans.also {
//            list.forEach { i, arrayList ->
//                println("$i: ${arrayList.joinToString(",")}")
//            }
//            println("ans is $it")
        }
    }

    private fun dfs(u: Int): Int {
        isVisited.add(u)
        var curr_ret = 0
        var add = 0
        list.getOrDefault(u, arrayListOf()).forEach { v ->
            if (v !in isVisited) {
                val next_ret = dfs(v)
                if (next_ret > curr_ret) {
                    add = curr_ret
                    curr_ret = next_ret
                } else if (next_ret > add) {
                    add = next_ret
                }
            }
        }
        ans = maxOf(ans, curr_ret + add)
        return curr_ret + 1
    }
}