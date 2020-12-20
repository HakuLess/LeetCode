package leetcode.contest.cur.leetcode.c220

import leetcode.contest.utils.UFS
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5632()
//    s.distanceLimitedPathsExist(3,
//            arrayOf(
//                    intArrayOf(0, 1, 2),
//                    intArrayOf(1, 2, 4),
//                    intArrayOf(2, 0, 8),
//                    intArrayOf(1, 0, 16)
//            ),
//            arrayOf(
//                    intArrayOf(0, 2, 5)
//            )
//    ).print()

    s.distanceLimitedPathsExist(5,
            arrayOf(
                    intArrayOf(0, 1, 10),
                    intArrayOf(1, 2, 5),
                    intArrayOf(2, 3, 9),
                    intArrayOf(3, 4, 13)
            ),
            arrayOf(
                    intArrayOf(0, 4, 14),
                    intArrayOf(1, 4, 13)
            )
    ).print()
}

class Solution5632 {
    fun distanceLimitedPathsExist(n: Int, edgeList: Array<IntArray>, queries: Array<IntArray>): BooleanArray {
        val st = queries.sortedBy { it[2] }
        val edges = edgeList.sortedBy { it[2] }
        val map = HashMap<String, Boolean>()

        var i = 0
        val ufs = UFS(n)
        st.forEach { q ->
            while (i in edges.indices && edges[i][2] < q[2]) {
                ufs.union(edges[i][0], edges[i][1])
                i++
            }
            val key = q.joinToString(",")
            map[key] = ufs.find(q[0]) == ufs.find(q[1])
        }
        return queries.map { q ->
            val key = q.joinToString(",")
            map[key]!!
        }.toBooleanArray()
    }

//    fun distanceLimitedPathsExist(n: Int, edgeList: Array<IntArray>, queries: Array<IntArray>): BooleanArray {
//        val dis = HashMap<Int, ArrayList<Pair<Int, Int>>>()
//        edgeList.forEach {
//            dis[it[0]] = dis.getOrDefault(it[0], arrayListOf())
//            dis[it[0]]!!.add(Pair(it[1], it[2]))
//            dis[it[1]] = dis.getOrDefault(it[1], arrayListOf())
//            dis[it[1]]!!.add(Pair(it[0], it[2]))
//        }
//        val seen = HashMap<Pair<Int, Int>, Int>()
//        val search = HashSet<Pair<Int, Int>>()
//        fun dfs(i: Int, j: Int): Int {
//            val key = Pair(i, j)
//            if (key in search) return Int.MAX_VALUE / 2
//            search.add(key)
//
//            if (key in seen) return seen[key]!!
//            if (i == j) return 0
//            return (dis.getOrDefault(i, arrayListOf()).map { value ->
//                maxOf(value.second, dfs(value.first, j))
//            }.min() ?: Int.MAX_VALUE).also {
//                seen[key] = it
//            }
//        }
//
//        val ans = ArrayList<Boolean>()
//        queries.forEach {
//            ans.add(dfs(it[0], it[1]) < it[2])
//        }
//        return ans.toBooleanArray()
//    }
}