package leetcode.contest.cur.leetcode.c198

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5465()
    s.countSubTrees(7, arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(1, 4),
            intArrayOf(1, 5),
            intArrayOf(2, 3),
            intArrayOf(2, 6)
    ), "abaedcd").print()
}

class Solution5465 {
    fun countSubTrees(n: Int, edges: Array<IntArray>, labels: String): IntArray {
        val graph = HashMap<Int, ArrayList<Int>>()
        for (i in 0 until n) {
            graph[i] = arrayListOf()
        }
        edges.forEach {
            graph[it[0]]!!.add(it[1])
            graph[it[1]]!!.add(it[0])
        }

        val ans = IntArray(n)
        val seen = HashSet<Int>()
        fun dfs(node: Int): HashMap<Char, Int> {
            val label = labels[node]
            val cur = HashMap<Char, Int>()
            cur[label] = 1
            seen.add(node)
            graph[node]?.forEach {
                if (it !in seen) {
                    val map = dfs(it)
                    map.forEach {
                        cur[it.key] = cur.getOrDefault(it.key, 0) + it.value
                    }
                }
                ans[node] = cur[label]!!
            }
            return cur
        }
        dfs(0)
        return ans
    }
}